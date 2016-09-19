export default class GroupService {
  /* @ngInject */
  constructor ($http, server) {
    this.$http = $http
    this.server = server
  }

  getAllGroups () {
    return this.$http
      .get(this.server + 'api/groups')
      .then((groups) => groups.data)
  }

  getGroup (id) {
    return this.$http
      .get(this.server + 'api/groups/' + id)
      .then((group) => group.data)
  }

  getMembers (id) {
    return this.$http
      .get(this.server + 'api/groups/' + id + '/members')
      .then((members) => members.data)
  }

  editGroup (id) {
    return (id, group) => {
      this.$http.patch(this.server + 'api/groups/' + id, group)
    }
  }
}