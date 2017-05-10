app.controller('resumeController', function($scope, $http){
    $scope.resumes = [];
    $http.get('browseResumes').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});
