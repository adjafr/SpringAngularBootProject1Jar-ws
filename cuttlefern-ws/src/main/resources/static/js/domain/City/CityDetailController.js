angular.module('app').controller('CityDetailController', ['CityDetailService', '$routeParams', '$location', function(CityDetailService, $routeParams, $location)
{
	
	var ctrl = this;
	
	CityDetailService.getCityDetails($routeParams.id).then(function(result){
		ctrl.city = result.data;
		
		ctrl.updateCityDetails = function()
		{
			CityDetailService.patchCityDetails(ctrl.city).then(function(){$location.path('#/cities')})
		}
	});
	
	ctrl.availableRoles = ['admin', 'person', 'guest'];
	
	ctrl.roleSelected = function(role)
	{
		ctrl.person.role.role = role;
	}
	
	

	
	
	
}]);