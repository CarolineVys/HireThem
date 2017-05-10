app.controller('addVacancyController', function($scope, $http){
    $scope.resumes = [];
    $http.get('submitVacancy').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});

