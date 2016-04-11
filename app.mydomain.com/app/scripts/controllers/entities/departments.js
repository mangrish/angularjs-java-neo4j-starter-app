(function () {
    'use strict';

    angular.module('app').controller('DepartmentsController', DepartmentsController);

    DepartmentsController.$inject = ['departments'];

    function DepartmentsController(departments) {

        var vm = this;

        vm.departments = departments;
        
        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
