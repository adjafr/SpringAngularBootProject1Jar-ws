import templateUrl from '../templates/entity-detail.template.html'
import CityController from './city.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: CityController,
  bindings: {
    entity: '<',
    people: '<',
    groups: '<',
    interests: '<'
  }
}