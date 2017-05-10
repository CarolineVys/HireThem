app.controller('vacancyController', function($scope, $http){
    $scope.resumes = [];
    $http.get('browseVacancies').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});

