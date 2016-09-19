import templateUrl from '../templates/entity-detail.template.html'
import PersonController from './person.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: PersonController,
  bindings: {
    entity: '<'
  }
}