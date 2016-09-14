angular.module('app').controller('PersonController', ['PersonDetailService', 'PersonService','allPeople', function PersonController(PersonDetailService, PersonService, allPeople) {

	var ctrl = this;
	
	ctrl.people = allPeople.data;
	
	console.dir(ctrl.people);
	
	ctrl.save = PersonDetailService.patchPersonDetails(ctrl.people)
	
}]);