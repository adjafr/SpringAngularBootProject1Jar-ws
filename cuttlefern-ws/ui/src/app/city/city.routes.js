export default function route ($stateProvider) {
  $stateProvider
    .state('cities', {
      url: '/cities',
      component: 'appCity',
      resolve: {
        entities: function (cityService) {
          return cityService.getAllCities()
        }
      }
    })
    .state('cityDetail', {
      url: '/cities/:id',
      component: 'appCityDetail',
      resolve: {
        entity: function (cityService, $stateParams) {
          return cityService.getCity($stateParams.id)
        },
        people: function (cityService, $stateParams) {
          return cityService.getCityPeople($stateParams.id)
        },
        groups: function (cityService, $stateParams) {
          return cityService.getCityGroups($stateParams.id)
        },
        interests: function (cityService, $stateParams) {
          return cityService.getCityInterests($stateParams.id)
        }
      }
    })
}