import templateUrl from '../templates/entity-detail.template.html'
import InterestController from './interest.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: InterestController,
  bindings: {
    entity: '<',
    people: '<',
    groups: '<',
    cities: '<',
    states: '<'
  }
}