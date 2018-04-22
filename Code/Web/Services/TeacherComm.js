(function(){

    'use strict'

    var app = angular.module('Assig2');

    app.service('TeacherComm', ['$http', 'APIAddress', function($http, APIAddress){

        var baseUrl = "http://" + APIAddress + ":8080/teacher";

        this.getTeachers = function(){

            return $http({
                method: 'GET',
                url: baseUrl + "/getAll"
            });

        };

        this.getTeacher = function(id){

            return $http({
                method: 'GET',
                url: baseUrl + "/get",
                params:{
                    teacherId: id
                }
            });

        };

        this.createTeacher = function(name, surname){

            return $http({
                method: 'GET',
                url: baseUrl + "/create",
                params:{
                    name: name,
                    surname: surname
                }
            });

        };

        this.updateTeacher = function(id, name, surname){

            return $http({
                method: 'GET',
                url: baseUrl + "/update",
                params:{
                    id: id,
                    name: name,
                    surname: surname
                }
            });

        };

        this.giveGrade = function(studentId, mark, examId){

            return $http({
                method: 'GET',
                url: baseUrl + "/giveGrade",
                params:{
                    studentId: studentId,
                    mark: mark,
                    examId: examId
                }
            });

        };

        this.generateReport = function(studentId){

            return $http({

                method: 'GET',
                url: baseUrl + "/generateReport",
                params: {
                    studentId: studentId
                }

            });

        };

    }]);

})();