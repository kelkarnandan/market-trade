var markettradeApp = angular.module('markettrade', ['nvd3']);

markettradeApp.controller('MainController', function($http, $scope, $log) {
	var vm = this;

	vm.markettrade;

	vm.allMarketTrade = function() {
		$http.get('/marketTrade/allMarketTrade').then(function(response) {
			console.log("Length : " + response.data.length > 0 );
			$scope.showList = response.data.length > 0 ? true : false;
			$scope.markettrades = response.data;
		});
		
	};
	
	vm.fromCurrencyVolume = function() {
		$http.get('/marketTrade/fromCurrencyTrade').then(function(response) {
			console.log("Length : " + response.data );
			$scope.showList = response.data.length > 0 ? true : false;
			$scope.fromCurrencyTrades = response.data;
		});
	};

});