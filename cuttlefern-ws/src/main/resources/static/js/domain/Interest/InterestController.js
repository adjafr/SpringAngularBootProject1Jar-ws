angular.module('app').controller('InterestController', ['InterestDetailService', 'InterestService','allInterests', function InterestController(InterestDetailService, InterestService, allInterests) {

	var ctrl = this;
	
	ctrl.interests = allInterests.data;
	
	console.dir(ctrl.interests);
	
	ctrl.save = InterestDetailService.patchInterestDetails(ctrl.interests)
	
}]);