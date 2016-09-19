import templateUrl from '../templates/entity.template.html'
import InterestController from './interest.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: InterestController,
  bindings: {
    entities: '<'
  }
}