angular.module('app').service('PersonDetailService', ['$http', function($http) {
	
	var url = 'api/people/';
	
	this.getPersonDetails = function(id) { return $http.get(url + id) };
	this.patchPersonDetails = function(person) { return $http.patch(url + person.id, person)}
	
}])

// $scope.$apply() fixes double sided binding ussues in AngularJS