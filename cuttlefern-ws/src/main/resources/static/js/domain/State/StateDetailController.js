angular.module('app').controller('StateDetailController', ['StateDetailService', '$routeParams', '$location', function(StateDetailService, $routeParams, $location)
{
	
	var ctrl = this;
	
	StateDetailService.getStateDetails($routeParams.id).then(function(result){
		ctrl.state = result.data;
		
		ctrl.updateStateDetails = function()
		{
			StateDetailService.patchStateDetails(ctrl.state).then(function(){$location.path('#/states')})
		}
	});
	
	ctrl.availableRoles = ['admin', 'person', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.person.role.role = role;
	}
	
	

	
	
	
}]);