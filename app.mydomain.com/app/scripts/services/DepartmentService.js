(function () {
    'use strict';

    angular.module('app').factory('DepartmentService', DepartmentService);

    DepartmentService.$inject = ['Restangular'];

    function DepartmentService(Restangular) {

        return {
            findAll: findAll,
            find: find
        };
        
        function findAll() {
            return Restangular.all('departments').getList();
        }

        function find(id) {
            return Restangular.one('departments', id).get();
        }
    }
})();
