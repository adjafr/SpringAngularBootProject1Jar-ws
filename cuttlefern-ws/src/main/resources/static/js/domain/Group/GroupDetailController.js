angular.module('app').controller('GroupDetailController', ['GroupDetailService', '$routeParams', '$location', function(GroupDetailService, $routeParams, $location)
{
	
	var ctrl = this;
	
	GroupDetailService.getGroupDetails($routeParams.id).then(function(result){
		ctrl.group = result.data;
		
		ctrl.updateGroupDetails = function()
		{
			GroupDetailService.patchGroupDetails(ctrl.group).then(function(){$location.path('#/groups')})
		}
	});
	
	ctrl.availableRoles = ['admin', 'person', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.person.role.role = role;
	}
	
	

	
	
	
}]);