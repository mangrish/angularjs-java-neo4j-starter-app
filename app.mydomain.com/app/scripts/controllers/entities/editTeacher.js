(function () {
    'use strict';

    angular.module('app').controller('EditTeacherController', EditTeacherController);

    EditTeacherController.$inject = ['teacher'];

    function EditTeacherController(teacher) {

        var vm = this;

        vm.teacher = teacher;

        vm.init = init;

        vm.init();

        // -------------------------------------------------------------------------------------------------------------
        // //// FUNCTIONS
        // -------------------------------------------------------------------------------------------------------------

        function init() {
        }
    }
})();
