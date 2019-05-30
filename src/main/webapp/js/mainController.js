var mainApp = angular.module('mainApp', []);
mainApp.controller('FunctorCtrl', function ($scope, $http){
    $http.get(location.href + 'functors').success(function(data) {
        $scope.functors = data;
    });
});

mainApp.controller('RelationCtrl', function ($scope, $http) {
    $http.get(location.href + 'relations').success(function(data) {
        $scope.relations = data;
    });
});

mainApp.controller('ClassCtrl', function ($scope, $http) {
    $http.get(location.href + 'classes').success(function(data) {
        $scope.classes = data;
    });
});

mainApp.controller('TmodelCtrl', function ($scope, $http) {
    $http.get(location.href + 'tmodels').success(function(data) {
        $scope.tmodels = data;
    });
});