import interest from './interest.component'
import interestDetail from './interest-detail.component'

import InterestService from './interest.service'

import routes from './interest.routes'

export default angular.module('app.interest', [])
  .service('interestService', InterestService)
  .component('appInterest', interest)
  .component('appInterestDetail', interestDetail)
  .config(routes)
  .name