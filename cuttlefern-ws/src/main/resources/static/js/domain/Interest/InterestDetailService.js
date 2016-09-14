angular.module('app').service('InterestDetailService', ['$http', function($http) {
	
	var url = 'api/interests/';
	
	this.getInterestDetails = function(id) { return $http.get(url + id) };
	this.patchInterestDetails = function(interest) { return $http.patch(url + interest.id,interest)};
	
}])