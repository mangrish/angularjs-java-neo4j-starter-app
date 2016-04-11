(function () {
    'use strict';

    angular.module('app').controller('TeachersController', TeachersController);

    TeachersController.$inject = [];

    function TeachersController() {

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
