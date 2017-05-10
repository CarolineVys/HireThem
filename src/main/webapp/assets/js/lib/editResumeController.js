app.controller('editResumeController', function($scope, $http){
    $scope.resumes = [];
    $http.get('submitEditResume').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});

