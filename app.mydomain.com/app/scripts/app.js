(function () {
    'use strict';

    /**
     * @ngdoc overview
     * @name app
     * @description
     * # app
     *
     * Main module of the application.
     */
    angular
        .module('app', [
            'ngAnimate',
            'ngAria',
            'ngCookies',
            'ngMessages',
            'restangular',
            'ui.router',
            'ui.router.default',
            'ngSanitize',
            'ngMaterial',
            'app.config'
        ])
        .config(appConfig)
        .constant('EVENTS', {
            serverError: 'event:serverError',
            clientError: 'event:clientError'
        })
        .run(runPage);

    appConfig.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider', 'RestangularProvider', 'config'];
    runPage.$inject = ['$rootScope', 'EVENTS', '$mdToast'];


    function appConfig($stateProvider, $urlRouterProvider, $locationProvider, RestangularProvider, config) {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'views/main.html',
                controller: 'MainCtrl as main'
            })
            .state('reports', {
                abstract: '.popularStudyBuddies',
                url: '/reports',
                templateUrl: 'views/reports.html',
                controller: 'ReportsController as vm'
            })
            .state('reports.popularStudyBuddies', {
                url: '/profile',
                templateUrl: 'views/reports/popular_study_buddies.html',
                controller: 'PopularStudyBuddiesController as vm',
                data: {
                    'selectedReportTab': 0
                }
            })
            .state('entities', {
                abstract: '.departments',
                url: '/entities',
                templateUrl: 'views/entities.html',
                controller: 'EntitiesController as vm'
            })
            .state('entities.departments', {
                url: '/departments',
                data: {
                    'selectedEntityTab': 0
                },
                views: {
                    "entities": {
                        templateUrl: 'views/entities/departments.html',
                        controller: 'DepartmentsController as vm'
                    }
                },
                resolve: {
                    departments: ['DepartmentService', function (DepartmentService) {
                        return DepartmentService.findAll();
                    }]
                }
            })
            .state('entities.departments.edit', {
                url: '/:id',
                views: {
                    "entities@entities": {
                        templateUrl: 'views/entities/edit_department.html',
                        controller: 'EditDepartmentController as vm'
                    }
                },
                resolve: {
                    department: ['DepartmentService', '$stateParams', function (DepartmentService, $stateParams) {
                        return DepartmentService.find( $stateParams.id);
                    }]
                }
            })
            .state('entities.teachers', {
                url: '/teachers',
                data: {
                    'selectedEntityTab': 1
                },
                views: {
                    "entities": {
                        templateUrl: 'views/entities/teachers.html',
                        controller: 'TeachersController as vm'
                    }
                },
                resolve: {
                    teachers: ['TeacherService', function (TeacherService) {
                        return TeacherService.findAll();
                    }]
                }
            })
            .state('entities.teachers.edit', {
                url: '/:id',
                views: {
                    "entities@entities": {
                        templateUrl: 'views/entities/edit_teacher.html',
                        controller: 'EditTeacherController as vm'
                    }
                },
                resolve: {
                    teacher: ['TeacherService', '$stateParams', function (TeacherService, $stateParams) {
                        return TeacherService.find( $stateParams.id);
                    }]
                }
            })
            .state('entities.students', {
                url: '/students',
                data: {
                    'selectedEntityTab': 2
                },
                views: {
                    "entities": {
                        templateUrl: 'views/entities/students.html',
                        controller: 'StudentsController as vm'
                    }
                },
                resolve: {
                    students: ['StudentService', function (StudentService) {
                        return StudentService.findAll();
                    }]
                }
            })
            .state('entities.students.edit', {
                url: '/:id',
                views: {
                    "entities@entities": {
                        templateUrl: 'views/entities/edit_student.html',
                        controller: 'EditStudentController as vm'
                    }
                },
                resolve: {
                    student: ['StudentService', '$stateParams', function (StudentService, $stateParams) {
                        return StudentService.find( $stateParams.id);
                    }]
                }
            })
            .state('entities.subjects', {
                url: '/subjects',
                data: {
                    'selectedEntityTab': 3
                },
                views: {
                    "entities": {
                        templateUrl: 'views/entities/subjects.html',
                        controller: 'SubjectsController as vm'
                    }
                },
                resolve: {
                    subjects: ['SubjectService', function (SubjectService) {
                        return SubjectService.findAll();
                    }]
                }
            })
            .state('entities.subjects.edit', {
                url: '/:id',
                views: {
                    "entities@entities": {
                        templateUrl: 'views/entities/edit_subject.html',
                        controller: 'EditSubjectController as vm'
                    }
                },
                resolve: {
                    subject: ['SubjectService', '$stateParams', function (SubjectService, $stateParams) {
                        return SubjectService.find( $stateParams.id);
                    }]
                }
            });

        $urlRouterProvider.otherwise('/');

        RestangularProvider.setBaseUrl(config.restApiUrl);
        RestangularProvider.setRequestInterceptor(function (elem, operation) {
            if (operation === "remove") {
                return null;
            }
            return elem;
        });

        $locationProvider.html5Mode(true);
    }

    function runPage($rootScope, EVENTS, $mdToast) {

        $rootScope.$on("$stateChangeError", console.log.bind(console));

        $rootScope.$on(EVENTS.serverError, function (event, eventData) {
            $mdToast.show(
                $mdToast.simple()
                    .content('An unexpected server error has occurred. Please try again.')
                    .action('OK')
                    .highlightAction(false)
                    .position('bottom left')
            );
        });
        $rootScope.$on(EVENTS.clientError, function (event, eventData) {
            $mdToast.show(
                $mdToast.simple()
                    .content(eventData.data.error)
                    .action('OK')
                    .highlightAction(false)
                    .position('bottom left')
            );
        });
    }
})();
