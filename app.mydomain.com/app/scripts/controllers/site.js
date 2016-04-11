(function () {
    'use strict';

    angular.module('app').controller('SiteController', SiteController);

    SiteController.$inject = ['config', '$mdSidenav'];

    function SiteController(config, $mdSidenav) {

        var vm = this;

        vm.build = undefined;

        vm.init = init;
        vm.toggleSidenav = toggleSidenav;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
            vm.build = config.build;
        }

        function toggleSidenav() {
            if (!$mdSidenav('left').isLockedOpen()) {
                $mdSidenav('left').toggle();
            }
        }

    }
})();
