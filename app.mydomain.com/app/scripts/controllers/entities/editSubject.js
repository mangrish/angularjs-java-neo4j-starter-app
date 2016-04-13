(function () {
    'use strict';

    angular.module('app').controller('EditSubjectController', EditSubjectController);

    EditSubjectController.$inject = ['subject'];

    function EditSubjectController(subject) {

        var vm = this;

        vm.subject = subject;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
