angular.module('app').service('CityDetailService', ['$http', function($http) {
	
	var url = 'api/cities/';
	
	this.getCityDetails = function(id) { return $http.get(url + id) };
	this.patchCityDetails = function(city) { return $http.patch(url + city.id, city)};
	
}])