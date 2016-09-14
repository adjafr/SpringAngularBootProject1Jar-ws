angular.module('app').controller('InterestDetailController', ['InterestDetailService', '$routeParams', '$location', function(InterestDetailService, $routeParams, $location)
{
	
	var ctrl = this;
	
	InterestDetailService.getInterestDetails($routeParams.id).then(function(result){
		ctrl.interest = result.data;
		
		ctrl.updateInterestDetails = function()
		{
			console.dir("I'm here");
			InterestDetailService.patchInterestDetails(ctrl.interest).then(function(){$location.path('#/interests')})
		}
	});
	
	ctrl.availableRoles = ['admin', 'person', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.person.role.role = role;
	}
	
	

	
	
	
}]);