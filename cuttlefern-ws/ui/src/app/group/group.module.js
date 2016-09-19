import group from './group.component'
import groupDetail from './group-detail.component'

import GroupService from './group.service'

import routes from './group.routes'

export default angular.module('app.group', [])
  .service('groupService', GroupService)
  .component('appGroup', group)
  .component('appGroupDetail', groupDetail)
  .config(routes)
  .name