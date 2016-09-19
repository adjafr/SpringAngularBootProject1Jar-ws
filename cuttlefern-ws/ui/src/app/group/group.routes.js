export default function route ($stateProvider) {
  $stateProvider
    .state('groups', {
      url: '/groups',
      component: 'appGroup',
      resolve: {
        entities: function (groupService) {
          return groupService.getAllGroups()
        }
      }
    })
    .state('groupDetail', {
      url: '/groups/:id',
      component: 'appGroupDetail',
      resolve: {
        entity: function (groupService, $stateParams) {
          return groupService.getGroup($stateParams.id)
        },
        members: function (groupService, $stateParams) {
          return groupService.getMembers($stateParams.id)
        }
      }
    })
}