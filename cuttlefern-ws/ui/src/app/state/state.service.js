export default class StateService {
  /* @ngInject */
  constructor ($http, server) {
    this.$http = $http
    this.server = server
  }

  getAllStates () {
    return this.$http
      .get(this.server + 'api/states')
      .then((states) => states.data)
  }

  getState (id) {
    return this.$http
      .get(this.server + 'api/states/' + id)
      .then((states) => states.data)
  }

  getStateCities (id) {
    return this.$http
      .get(this.server + 'api/states/' + id + '/cities')
      .then((cities) => cities.data)
  }

  getStateInterests (id) {
    return this.$http
      .get(this.server + 'api/states/' + id + '/interests')
      .then((interests) => interests.data)
  }

  getStateGroups (id) {
    return this.$http
      .get(this.server + 'api/states/' + id + '/groups')
      .then((groups) => groups.data)
  }

  getStatePeople (id) {
    return this.$http
      .get(this.server + 'api/states/' + id + '/people')
      .then((people) => people.data)
  }
}