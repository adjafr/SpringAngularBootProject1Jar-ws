import uiRouter from 'angular-ui-router'

import appHome from './app.component'
import routes from './app.routes'
import person from './person/person.module'
import group from './group/group.module'
import interest from './interest/interest.module'
import city from './city/city.module'
import state from './state/state.module'

import '../css/main.css'

export default
  angular
    .module('app', [uiRouter, person, group, interest, city, state])
    .constant('server', 'http://localhost:8080/')
    .component('appHome', appHome)
    .config(routes)
    .name