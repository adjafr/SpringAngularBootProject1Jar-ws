export default class InterestService {
  /* @ngInject */
  constructor ($http, server) {
    this.$http = $http
    this.server = server
  }

  getAllInterests () {
    return this.$http
      .get(this.server + '/api/interests')
      .then((interests) => interests.data)
  }

  getInterest (id) {
    return this.$http
      .get(this.server + 'api/interests/' + id)
      .then((interest) => interest.data)
  }

  getInterestPeople (id) {
    return this.$http
      .get(this.server + 'api/interests/' + id + '/people')
      .then((people) => people.data)
  }

  getInterestGroups (id) {
    return this.$http
      .get(this.server + 'api/interests/' + id + '/groups')
      .then((groups) => groups.data)
  }

  getInterestCities (id) {
    return this.$http
      .get(this.server + 'api/interests/' + id + '/cities')
      .then((cities) => cities.data)
  }

  getInterestStates (id) {
    return this.$http
      .get(this.server + 'api/interests/' + id + '/states')
      .then((states) => states.data)
  }
}