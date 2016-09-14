angular.module('app').controller('PersonDetailController', ['PersonDetailService', '$routeParams', '$location', function(PersonDetailService, $routeParams, $location)
{
	
	var ctrl = this;
	
	PersonDetailService.getPersonDetails($routeParams.id).then(function(result){
		ctrl.person = result.data;
		
		ctrl.updatePersonDetails = function()
		{
			PersonDetailService.patchPersonDetails(ctrl.person).then(function(){$location.path('#/homePage')})
		}
		
	});
	
	ctrl.availableRoles = ['admin', 'person', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.person.role.role = role;
	}
	
	

	
	
	
}]);