import person from './person.component'
import personDetail from './person-detail.component'

import PersonService from './person.service'

import routes from './person.routes'

export default angular.module('app.person', [])
  .service('personService', PersonService)
  .component('appPerson', person)
  .component('appPersonDetail', personDetail)
  .config(routes)
  .name