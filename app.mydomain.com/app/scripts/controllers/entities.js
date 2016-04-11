(function () {
    'use strict';

    angular.module('app').controller('EntitiesController', EntitiesController);

    EntitiesController.$inject = ['$scope'];

    function EntitiesController($scope) {

        var vm = this;
        vm.selectedEntityTab = null;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
            $scope.$on('$stateChangeSuccess', function(event, toState) {
                if (toState.data) {
                    vm.selectedEntityTab = toState.data.selectedEntityTab;
                }
            });
        }
    }
})();
