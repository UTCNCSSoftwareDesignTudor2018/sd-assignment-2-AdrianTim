(function () {

    'use strict'

    var app = angular.module('Assig2');

    app.controller('TeacherPageController', ['APIAddress', '$scope', '$routeParams', 'TeacherComm', 'StudentComm', 'CourseComm', function (APIAddress, $scope, $routeParams, TeacherComm, StudentComm, CourseComm) {

        $scope.courses = [];
        $scope.enrolledStudents = [];
        
        var studentId = undefined;
        var id = undefined;
        var courseSelected = undefined;

        $scope.init = function () {

            $scope.clickedCourse = false;
            $scope.clickedStudent = false;

            console.log("Opened teacher page with id : " + $routeParams.id);
            id = $routeParams.id;

            TeacherComm.getTeacher(id).then(function successCallback(response) {

                console.log(response.data);

                $scope.teacherName = response.data.name;
                $scope.teacherSurname = response.data.surname;

                $scope.courses = response.data.courses;

            }, function errorCallback(response) {

                console.log("Error getting teacher");

            });

        };

        $scope.createCourse = function () {

            if ($scope.subject != undefined) {

                CourseComm.createCourse($scope.subject, id).then(function successCallback(response) {
                    console.log("Success creating course");
                }, function errorCallback(response) {
                    console.log("Error creating course");
                })

            }

        };

        $scope.update = function () {

            if ($scope.teacherName != undefined && $scope.teacherName != undefined) {

                TeacherComm.updateTeacher(id, $scope.teacherName, $scope.teacherSurname).then(function successCallback(response) {
                    console.log("Success updating teacher");
                }, function errorCallback(response) {
                    console.log("Error updating teacher");
                })

            };

        };

        $scope.getStudents = function (courseId) {

            courseSelected = courseId;

            StudentComm.getEnroled(courseId).then(function successCallback(response) {

                console.log("Got enrolled students");
                $scope.clickedCourse = true;
                $scope.enrolledStudents = response.data;

            }, function errorCallback(response) {

                console.log("Error getting students");

            });

        };

        $scope.displayStudentInfo = function (id) {

            StudentComm.getStudent(id).then(function (response) {

                console.log("Got student info");

                $scope.clickedStudent = true;

                var data = response.data;
                var studentId = data.id;        

                console.log(data);

                $scope.studentName = data.name;
                $scope.studentSurname = data.surname;
                $scope.studentPersonalNumber = data.personalNumber;
                $scope.studentAddress = data.address;


            }, function errorCallback(response) {

                console.log("Error getting student info");

            });

        };

        $scope.updateStudent = function(){

            StudentComm.updateStudent(studentId).then(function successCallback(response){
                console.log("Success updating student");
            }, function errorCallback(response){
                console.log("Error updating student");
            });

        };

        $scope.generateReport = function(){

            TeacherComm.generateReport(studentId).then(function successCallback(response){
                console.log("Created report");
            }, function errorCallback(response){
                console.log("Error creating report");
            });

        };

        $scope.giveGrade = function(){

            if($scope.mark != undefined){

                TeacherComm.giveGrade(studentId, $scope.mark, courseSelected).then(function successCallback(response){

                    console.log("graded");

                }, function errorCallback(response){
                    console.log("Error grading");
                });

            };

        };

    }]);

})();