app.controller("product-ctrl", function($scope, $http){
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};
	
	$scope.initialize = function() {
		// load products
		$http.get("/rest/products").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		})
		// load categories
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		})
	}
	// Khoi dau
	$scope.initialize();
	// Xoa form
	$scope.reset = function() {
		$scope.form = {
			createDate: new Date(),
			image: 'cloud-upload.jpg',
			available: true
		};
	}
	// Hien thi len form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		
	}
	// Them san pham moi
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/products`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm thành công")
		}).catch(error => {
			alert("Failed");
			console.log("error", error)
		})
	}
	// Cap nhat
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/products/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật thành công")
		}).catch(error => {
			alert("Failed");
			console.log("error", error)
		})
	}
	$scope.delete = function(item) {
		var item = angular.copy($scope.form);
		$http.delete(`/rest/products/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			if (confirm('Bạn có muốn xóa ') == true){
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("Xóa thành công")
			}
		}).catch(error => {
			alert("Failed");
			console.log("error", error)
		})
	}
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/image', data, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Error upload");
			console.log("Error", error);
		})
	}
	
	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		
		get count() {
			return Math.ceil($scope.items.length / this.size);
		},
		
		first() {
			this.page = 0;
			if(this.page >= this.count) {}
			this.first();
		},
		
		prev() {
			this.page--;
			if(this.page < 0) {
				this.last();
			}
		},
		
		next() {
			this.page++
		},
		
		last() {
			this.page = this.count - 1;
		}
	}
})