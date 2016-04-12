(function () {
    'use strict';

    angular.module('app').controller('EditDepartmentController', EditDepartmentController);

    EditDepartmentController.$inject = ['department'];

    function EditDepartmentController(department) {

        var vm = this;

        vm.department = department;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
