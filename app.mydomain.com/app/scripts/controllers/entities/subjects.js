(function () {
    'use strict';

    angular.module('app').controller('SubjectsController', SubjectsController);

    SubjectsController.$inject = ['subjects'];

    function SubjectsController(subjects) {

        var vm = this;

        vm.subjects = subjects;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
