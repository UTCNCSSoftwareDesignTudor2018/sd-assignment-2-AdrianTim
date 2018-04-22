(function(){

    'use strict'

    var app = angular.module('Assig2');

    app.service('CourseComm', ['$http', 'APIAddress', function($http, APIAddress){

        var baseUrl = "http://" + APIAddress + ":8080/course";

        this.createCourse = function(subject, teacherId){

            return $http({
                method: 'GET',
                url: baseUrl + "/create",
                params: {
                    subject: subject,
                    teacherId: teacherId
                }
            });

        };

        this.addExam = function(courseId, room, date){

            return $http({
                method: 'GET',
                url: baseUrl + "/addExam",
                params: {
                    courseId: courseId,
                    room: room,
                    date: date
                }
            });

        };

    }])

})();