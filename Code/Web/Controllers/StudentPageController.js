(function(){

    'use strict'

    var app = angular.module('Assig2');

    app.controller('StudentPageController', ['APIAddress', '$scope', '$routeParams', 'StudentComm', function(APIAddress, $scope, $routeParams, StudentComm){

        $scope.courses = [];
        $scope.availableCourses = [];

        var studentId = undefined;

        $scope.init = function(){

            var id = $routeParams.id;
            studentId = id;

            StudentComm.getStudent(id).then(function successCallback(response){

                var data = response.data;

                console.log(data);
                
                $scope.studentName = data.name;
                $scope.studentSurname = data.surname;
                $scope.studentPersonalNumber = data.personalNumber;
                $scope.studentAddress = data.address;

                $scope.courses = data.courses;

            }, function errorCallback(){console.log("error retrieving student")});

            StudentComm.getAvailableCourses(id).then(function successCallback(response){

                $scope.availableCourses = response.data;

            }, function errorCallback(response){
                console.log("Error getting available courses");
            });

        };

        $scope.enrol = function(courseId){

            StudentComm.enrolStudent(studentId, courseId).then(function successCallback(response){

                console.log("Enrolled in course");

            }, function errorCallback(response){
                console.log("Error enrolling in course");
            })

        };

        $scope.update = function(){

            if($scope.studentName !=undefined && $scope.studentSurname != undefined && $scope.studentPersonalNumber != undefined && $scope.studentAddress != undefined){

                StudentComm.updateStudent(studentId, studentName, studentSurname, studentPersonalNumber, studentAddress).then(function successCallback(response){

                    console.log("Finished updating student");

                }, function errorCallback(response){

                    console.log("Error updating student");

                })

            }


        }

    }]);

})();