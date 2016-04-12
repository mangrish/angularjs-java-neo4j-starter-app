(function () {
    'use strict';

    angular.module('app').controller('TeachersController', TeachersController);

    TeachersController.$inject = ['teachers'];

    function TeachersController(teachers) {

        var vm = this;

        vm.teachers = teachers;
        
        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
