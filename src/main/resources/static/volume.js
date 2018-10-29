var myApp = angular.module('myApp', ['angular-filter']);

myApp.controller('MyController', function($http, $scope, $log) {
	var vm = this;

	vm.volumeData = function() {
		$http.get('/marketTrade/allMarketTrade').then(function(response) {
			console.log("Length : " + response.data.length > 0 );
			$scope.data = response.data;
		});
	};

	myApp.filter("groupByFilter", function(){
		
		
		
	});
	$scope.getVolumeSum = function(items) {
  	return items
    .map(function(x) { return x.amountSell; })
    .reduce(function(a, b) { return a + b; });
  };

});