import templateUrl from '../templates/entity-detail.template.html'
import GroupController from './group.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: GroupController,
  bindings: {
    entity: '<',
    members: '<'
  }
}