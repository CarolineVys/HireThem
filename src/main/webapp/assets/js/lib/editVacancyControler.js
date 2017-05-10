app.controller('editVacancyController', function($scope, $http){
    $scope.resumes = [];
    $http.get('submitEditVacancy').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});


