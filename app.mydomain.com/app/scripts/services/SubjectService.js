(function () {
    'use strict';

    angular.module('app').factory('SubjectService', SubjectService);

    SubjectService.$inject = ['Restangular'];

    function SubjectService(Restangular) {

        return {
            findAll: findAll,
            find: find
        };

        function findAll() {
            return Restangular.all('subjects').getList();
        }

        function find(id) {
            return Restangular.one('subjects', id).get();
        }
    }
})();
