export default function route ($stateProvider) {
  $stateProvider
    .state('interests', {
      url: '/interests',
      component: 'appInterest',
      resolve: {
        entities: function (interestService) {
          return interestService.getAllInterests()
        }
      }
    })
    .state('interestDetail', {
      url: '/interests/:id',
      component: 'appInterestDetail',
      resolve: {
        entity: function (interestService, $stateParams) {
          return interestService.getInterest($stateParams.id)
        },
        people: function (interestService, $stateParams) {
          return interestService.getInterestPeople($stateParams.id)
        },
        groups: function (interestService, $stateParams) {
          return interestService.getInterestGroups($stateParams.id)
        },
        cities: function (interestService, $stateParams) {
          return interestService.getInterestCities($stateParams.id)
        },
        states: function (interestService, $stateParams) {
          return interestService.getInterestStates($stateParams.id)
        }
      }
    })
}