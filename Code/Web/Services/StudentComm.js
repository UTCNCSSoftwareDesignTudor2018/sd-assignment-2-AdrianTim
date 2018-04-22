(function(){

    'use strict'

    var app = angular.module('Assig2');

    app.service('StudentComm', ['$http', 'APIAddress', function($http, APIAddress){

        var baseUrl = "http://" + APIAddress + ":8080/student";

        this.getStudents = function(){

            return $http({
                method: 'GET',
                url: baseUrl + "/getAll"
            });

        };

        this.getStudent = function(id){

            return $http({
                method: 'GET',
                url: baseUrl + "/get",
                params:{
                    id: id
                }
            });

        };

        this.createStudent = function(name, surname, personalNumber, address){

            return $http({
                method: 'GET',
                url: baseUrl + "/create",
                params:{
                    name: name,
                    surname: surname,
                    personalNumber: personalNumber,
                    address: address
                }
            });

        };

        this.updateStudent = function(id, name, surname, personalNumber, address){

            return $http({
                method: 'GET',
                url: baseUrl + "update",
                params:{
                    id: id,
                    name: name,
                    surname: surname,
                    personalNumber: personalNumber,
                    address: address
                }
            });

        };

        this.enrolStudent = function(studentId, courseId){

            return $http({
                method: 'GET',
                url: baseUrl + "/enrol",
                params:{
                    studentId: studentId,
                    courseId: courseId
                }
            });

        };

        this.getAvailableCourses = function(studentId){

            return $http({
                method: 'GET',
                url: baseUrl + "/getAvailableCourses",
                params:{
                    studentId: studentId
                }
            });

        };

        this.getExams = function(studentId){

            return $http({
                method: 'GET',
                url: baseUrl + "/getExams",
                params:{
                    studentId: studentId
                }
            });

        };

        this.getEnroled = function(courseId){

            return $http({
                method: 'GET',
                url: baseUrl + "/getStudentsEnrolled",
                params:{
                    courseId: courseId
                }
                
            });

        };

    }]);

})();