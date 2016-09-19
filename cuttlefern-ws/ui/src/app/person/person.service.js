export default class PersonService {
  /* @ngInject */
  constructor ($http, server) {
    this.$http = $http
    this.server = server
  }

  getAllPeople () {
    return this.$http
      .get(this.server + 'api/people')
      .then((people) => people.data)
  }

  getPerson (id) {
    return this.$http
      .get(this.server + 'api/people/' + id)
      .then((person) => person.data)
  }

  editPerson (id, person) {
    return () => {
      this.$http.patch(this.server + 'api/people/' + id, person)
    }
  }
}