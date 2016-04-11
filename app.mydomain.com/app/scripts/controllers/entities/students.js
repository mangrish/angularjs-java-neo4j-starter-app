(function () {
    'use strict';

    angular.module('app').controller('StudentsController', StudentsController);

    StudentsController.$inject = [];

    function StudentsController() {

        var vm = this;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
