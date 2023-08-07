const app = angular.module("registry-app",[]);

app.controller("registry-ctrl", function($http, $scope) {
	$scope.items = [];
	$scope.form = {
		roles: "ROLE_USER"
	};
	$scope.create = function() {
		var jsonData = angular.toJson($scope.form);
		$http.post(`/user/new`, jsonData).then(resp => {
			$scope.items.push(resp.data);
		}).catch(error => {
			alert("Đăng ký thành công - Chuyển về trang đăng nhập")
			location.href = "/auth/login/form"
			console.log("error", error)
		})
	}
})