(function () {

    'use strict'

    var app = angular.module('Assig2');

    app.controller('LandingPageController', ['APIAddress', '$scope', 'StudentComm', 'TeacherComm', '$location', function (APIAddress, $scope, StudentComm, TeacherComm, $location) {

        $scope.students = [];
        $scope.teachers = [];

        $scope.init = function () {

            StudentComm.getStudents().then(function successCallback(response) {
                $scope.students = response.data;
            }, function errorCallback(response) {
                console.log("Error retrieving students")
            });

            TeacherComm.getTeachers().then(function successCallback(response) {
                $scope.teachers = response.data;
            }, function errorCallback(response) {
                console.log("Error retrieving teachers");
            });

        };

        $scope.openStudentPage = function (id) {

            console.log("Opening student page with id : " + id);
            $location.path("/student/" + id);

        }

        $scope.openTeacherPage = function (id) {

            console.log("Opening teacher page with id : " + id);
            $location.path("/teacher/" + id);

        }

        $scope.createStudent = function () {

            console.log("Creating student....");

            if($scope.studentName !=undefined && $scope.studentSurname != undefined && $scope.studentPersonalNumber != undefined && $scope.studentAddress != undefined){

                StudentComm.createStudent($scope.studentName, $scope.studentSurname, $scope.studentPersonalNumber, $scope.studentAddress).then(function successCallback(response){
                    console.log("Created student");
                }, function errorCallback(response){
                    console.log("Error creating student");
                    console.log(response);
                });

            }else{
                console.log("Emnpty fields");
            }

        }

        $scope.createTeacher = function () {

            console.log("Creating teacher....");

            if ($scope.teacherName != undefined && $scope.teacherName != undefined) {

                console.log("Creating student...");
                TeacherComm.createTeacher($scope.teacherName, $scope.teacherSurname).then(function successCallback(response) {
                    console.log("Created teacher");
                }, function errorCallback(response) {
                    console.log("Error creating teacher");
                })

            } else {
                console.log("Empty fields...");
            }

        }

    }]);

})();