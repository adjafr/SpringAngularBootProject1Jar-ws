export default function route ($stateProvider) {
  $stateProvider
    .state('states', {
      url: '/states',
      component: 'appState',
      resolve: {
        entities: function (stateService) {
          return stateService.getAllStates()
        }
      }
    })
    .state('stateDetail', {
      url: '/states/:id',
      component: 'appStateDetail',
      resolve: {
        entity: function (stateService, $stateParams) {
          return stateService.getState($stateParams.id)
        },
        cities: function (stateService, $stateParams) {
          return stateService.getStateCities($stateParams.id)
        },
        people: function (stateService, $stateParams) {
          return stateService.getStatePeople($stateParams.id)
        },
        groups: function (stateService, $stateParams) {
          return stateService.getStateGroups($stateParams.id)
        },
        interests: function (stateService, $stateParams) {
          return stateService.getStateInterests($stateParams.id)
        }
      }
    })
}