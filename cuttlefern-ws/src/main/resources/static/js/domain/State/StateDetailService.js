angular.module('app').service('StateDetailService', ['$http', function($http) {
	
	var url = 'api/states/';
	
	this.getStateDetails = function(id) { return $http.get(url + id) };
	this.patchStateDetails = function(state) { return $http.patch(url + state.id,state)};
	
}])