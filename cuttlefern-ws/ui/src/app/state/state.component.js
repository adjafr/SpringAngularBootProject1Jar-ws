import templateUrl from '../templates/entity.template.html'
import StateController from './state.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: StateController,
  bindings: {
    entities: '<'
  }
}