import state from './state.component'
import stateDetail from './state-detail.component'

import StateService from './state.service'

import routes from './state.routes'

export default angular.module('app.state', [])
  .service('stateService', StateService)
  .component('appState', state)
  .component('appStateDetail', stateDetail)
  .config(routes)
  .name