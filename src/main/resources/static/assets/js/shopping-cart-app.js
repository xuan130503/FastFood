const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($http, $scope) {
	// Quan ly gio hang
	$scope.cart = {
		items: [],
		// Them san pham
		add(id){
			var item = this.items.find(item => item.id == id);
			if(item) {
				item.qty++;
				this.saveToLocalStorage();
			} else {
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		// Xoa san pham
		remove(id){
			if(confirm('Bạn có muốn xóa?') == true ) {
				var index = this.items.findIndex(item => item.id == id)
				this.items.splice(index, 1)
				this.saveToLocalStorage();
			}
		},
		// Xoa sach cac mat hang trong gio
		clearNow(){
			this.items = []
			this.saveToLocalStorage();
		},
		
		clear(){
			if (confirm('Bạn có muốn xóa toàn bộ?') == true) {
			    this.items = []
				this.saveToLocalStorage();
			}
		},
		// Tinh thanh tien cua mot san pham
		amt_of(item){},
		// Tinh tong so luong cua cac mat hang trong gio
		get count(){
			return this.items
				.map(item => item.qty)
				.reduce((total,qty) => total += qty,0);
		},
		// Tong thanh tien cac mat hang trong gio
		get amount(){
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total,qty) => total += qty,0);
		},
		// Luu gio hang vao local storage
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
		// Doc gio hang tu local storage
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.cart.loadFromLocalStorage();
	
	$scope.order = {
		createDate : new Date(),
		address: "",
		status: "Đang giao hàng",
		userinfo: {username: $("#username").text()},
		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					product : {id: item.id},
					price: item.price,
					quantity: item.qty
				}
			});
		},
		purchase() {
			var order = angular.copy(this);
			$http.post("/rest/orders", order).then(resp =>{
				alert('Thanh toán thành công');
				$scope.cart.clearNow();
				location.href = "/order/detail/" + resp.data.id;
			}).catch(error => {
				alert('Failed')
				console.log(error)
			})
		}
	}
})