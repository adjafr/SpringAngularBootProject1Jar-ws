export default function route ($stateProvider) {
  $stateProvider
    .state('people', {
      url: '/people',
      component: 'appPerson',
      resolve: {
        entities: function (personService) {
          return personService.getAllPeople()
        }
      }
    })
    .state('personDetail', {
      url: '/people/:id',
      component: 'appPersonDetail',
      resolve: {
        entity: function (personService, $stateParams) {
          return personService.getPerson($stateParams.id)
        }
      }
    })
}