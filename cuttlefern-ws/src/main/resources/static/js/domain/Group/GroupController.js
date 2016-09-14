angular.module('app').controller('GroupController', ['GroupDetailService', 'GroupService','allGroups', function GroupController(GroupDetailService, GroupService, allGroups) {

	var ctrl = this;
	
	ctrl.groups = allGroups.data;
	
	console.dir(ctrl.groups);
	
	ctrl.save = GroupDetailService.patchGroupDetails(ctrl.groups)
	
}]);