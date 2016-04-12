(function () {
    'use strict';

    angular.module('app').controller('StudentsController', StudentsController);

    StudentsController.$inject = ['students'];

    function StudentsController(students) {

        var vm = this;
        vm.students = students;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
