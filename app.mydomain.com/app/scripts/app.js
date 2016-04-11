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
            'ngResource',
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

    appConfig.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider', 'config', '$mdIconProvider'];
    runPage.$inject = ['$rootScope', 'EVENTS', '$mdToast'];


    function appConfig($stateProvider, $urlRouterProvider, $locationProvider) {
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
                templateUrl: 'views/entities/departments.html',
                controller: 'DepartmentsController as vm',
                data: {
                    'selectedEntityTab': 0
                },
                resolve: {
                    departments:['DepartmentService', function (DepartmentService) {
                        return DepartmentService.query();
                    }]
                }
            })
            .state('entities.teachers', {
                url: '/teachers',
                templateUrl: 'views/entities/teachers.html',
                controller: 'TeachersController as vm',
                data: {
                    'selectedEntityTab': 1
                }
            })
            .state('entities.students', {
                url: '/students',
                templateUrl: 'views/entities/students.html',
                controller: 'StudentsController as vm',
                data: {
                    'selectedEntityTab': 2
                }
            });

        $urlRouterProvider.otherwise('/');

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
