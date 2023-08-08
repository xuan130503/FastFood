var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
	.when("/product", {
		templateUrl: "/assets/admin/product/index.html",
		controller: "product-ctrl"
	})
	
	.when("/revenue", {
		templateUrl:"/assets/admin/revenue/index.html",
		controller: "authority-ctrl"
	})
	.otherwise({
	})
})