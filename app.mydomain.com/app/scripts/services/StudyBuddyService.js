(function () {
    'use strict';

    angular.module('app').factory('StudyBuddyService', StudyBuddyService);

    StudyBuddyService.$inject = ['Restangular'];

    function StudyBuddyService(Restangular) {

        return {
            findAll: findAll,
            find: find
        };
        
        function findAll() {
            return Restangular.all('studyBuddies').getList();
        }

        function find(id) {
            return Restangular.one('studyBuddies', id).get();
        }
    }
})();
