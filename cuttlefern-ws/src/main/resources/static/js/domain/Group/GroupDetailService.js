angular.module('app').service('GroupDetailService', ['$http', function($http) {
	
	var url = 'api/groups/';
	
	this.getGroupDetails = function(id) { return $http.get(url + id) };
	this.patchGroupDetails = function(group) { return $http.patch(url + group.id, group)};
	
}])