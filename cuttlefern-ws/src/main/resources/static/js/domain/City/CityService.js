/**
 * 
 */

angular.module('app').service('CityService', function($http){

	var url = 'api/cities';
	
	this.getAllCities = function() { return $http.get(url) };

	
});