export default class CityService {
  /* @ngInject */
  constructor ($http, server) {
    this.$http = $http
    this.server = server
  }

  getAllCities () {
    return this.$http
      .get(this.server + 'api/cities')
      .then((cities) => cities.data)
  }

  getCity (id) {
    return this.$http
      .get(this.server + 'api/cities/' + id)
      .then((city) => city.data)
  }

  getCityPeople (id) {
    return this.$http
      .get(this.server + 'api/cities/' + id + '/people')
      .then((people) => people.data)
  }

  getCityGroups (id) {
    return this.$http
      .get(this.server + 'api/cities/' + id + '/groups')
      .then((groups) => groups.data)
  }

  getCityInterests (id) {
    return this.$http
      .get(this.server + 'api/cities/' + id + '/interests')
      .then((interests) => interests.data)
  }
}