angular.module('app').controller('StateController', ['StateDetailService', 'StateService','allStates', function StateController(StateDetailService, StateService, allStates) {

	var ctrl = this;
	
	ctrl.states = allStates.data;
	
	console.dir(ctrl.states);
	
	ctrl.save = StateDetailService.patchStateDetails(ctrl.states)
	
}]);