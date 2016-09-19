import templateUrl from '../templates/entity-detail.template.html'
import StateController from './state.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: StateController,
  bindings: {
    entity: '<',
    cities: '<',
    interests: '<',
    groups: '<',
    people: '<'
  }
}