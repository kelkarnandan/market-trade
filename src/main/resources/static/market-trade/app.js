var markettradeApp = angular.module('markettrade', [ 'nvd3' ]);

markettradeApp.controller('MainController', function($http, $scope, $log) {
	var vm = this;

	vm.marketTradeList;
	vm.fromCurrencyVolume = function() {
		$http.get('/marketTrade/getByCurrencyAndTotal').then(
				function(response) {
					$scope.showList = response.data.length > 0 ? true : false;
					$scope.fromCurrencyTrades = response.data;
					marketTradeList = response.data;
					drawChart(marketTradeList);
				});
	};

});

var drawChart = function(data) {
	nv.addGraph(function() {
		var chart = nv.models.pieChart().x(function(d) {
			return d.currencyFrom + "/" + d.currencyTo
		}).y(function(d) {
			return d.total
		}).showLabels(true);

		d3.select("#chart svg").datum(data).transition().duration(1200).call(
				chart);

		return chart;
	});

};
