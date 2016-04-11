(function () {
    'use strict';

    angular.module('app').controller('PopularStudyBuddiesController', PopularStudyBuddiesController);

    PopularStudyBuddiesController.$inject = [];

    function PopularStudyBuddiesController() {

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
