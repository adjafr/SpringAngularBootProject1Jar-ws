import templateUrl from '../templates/entity.template.html'
import GroupController from './group.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: GroupController,
  bindings: {
    entities: '<'
  }
}