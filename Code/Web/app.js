(function(){

    'use strict'

    console.log("Starting....");
    
    var app = angular.module('Assig2', ['ngRoute', 'ngMaterial', 'ngMessages']);

    app.config(function($routeProvider){

        $routeProvider
            .when("/landing", {
                templateUrl: "Views/LandingPage.html",
                controller: "LandingPageController",
                controllerAs: "ctrl"
            })
            .when("/student/:id", {
                templateUrl: "Views/StudentPage.html",
                controller: "StudentPageController",
                controllerAs: "ctrl"
            })
            .when("/teacher/:id", {
                templateUrl: "Views/TeacherPage.html",
                controller: "TeacherPageController",
                controllerAs: "ctrl"
            })
            .otherwise({
                redirectTo: "/landing"
            });

    });

    app.value('APIAddress', 'localhost');

})();