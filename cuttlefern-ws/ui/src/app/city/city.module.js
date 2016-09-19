import city from './city.component'
import cityDetail from './city-detail.component'

import CityService from './city.service'

import routes from './city.routes'

export default angular.module('app.city', [])
  .service('cityService', CityService)
  .component('appCity', city)
  .component('appCityDetail', cityDetail)
  .config(routes)
  .name