(function () {
    'use strict';

    angular.module('app').controller('EditStudentController', EditStudentController);

    EditStudentController.$inject = ['student'];

    function EditStudentController(student) {

        var vm = this;

        vm.student = student;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
