app.controller('addResumeController', function($scope, $http){
    $scope.resumes = [];
    $http.get('submitResume').success(function (data) {
        $scope.resumes = data;
    }).error(function (data) {
        console.log("log")
    });
});
