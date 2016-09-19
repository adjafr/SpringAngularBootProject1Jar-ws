import templateUrl from '../templates/entity.template.html'
import PersonController from './person.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: PersonController,
  bindings: {
    entities: '<'
  }
}