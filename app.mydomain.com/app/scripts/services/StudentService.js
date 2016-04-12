(function () {
    'use strict';

    angular.module('app').factory('StudentService', StudentService);

    StudentService.$inject = ['Restangular'];

    function StudentService(Restangular) {

        return {
            findAll: findAll,
            find: find
        };
        
        function findAll() {
            return Restangular.all('students').getList();
        }

        function find(id) {
            return Restangular.one('students', id).get();
        }
    }
})();
