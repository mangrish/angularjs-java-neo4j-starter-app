(function () {
    'use strict';

    angular.module('app').controller('ReportsController', ReportsController);

    ReportsController.$inject = ['$scope'];

    function ReportsController($scope) {

        var vm = this;
        vm.selectedReportTab = null;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
            $scope.$on('$stateChangeSuccess', function(event, toState) {
                if (toState.data) {
                    vm.selectedReportTab = toState.data.selectedReportTab;
                }
            });
        }
    }
})();
