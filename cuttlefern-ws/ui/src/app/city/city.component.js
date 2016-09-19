import templateUrl from '../templates/entity.template.html'
import CityController from './city.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: CityController,
  bindings: {
    entities: '<'
  }
}