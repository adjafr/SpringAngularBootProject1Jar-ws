angular.module('app').controller('CityController', ['CityDetailService', 'CityService','allCities', function CityController(CityDetailService, CityService, allCities) {

	var ctrl = this;
	
	ctrl.cities = allCities.data;
	
	console.dir(ctrl.cities);
	
	ctrl.save = CityDetailService.patchCityDetails(ctrl.cities)
	
}]);