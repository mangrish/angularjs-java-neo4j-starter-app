(function () {
    'use strict';

    angular.module('app').factory('TeacherService', TeacherService);

    TeacherService.$inject = ['Restangular'];

    function TeacherService(Restangular) {

        return {
            findAll: findAll,
            find: find
        };

        function findAll() {
            return Restangular.all('teachers').getList();
        }

        function find(id) {
            return Restangular.one('teachers', id).get();
        }
    }
})();
