export default class GroupController {
  /* @ngInject */
  constructor () {
    this.name = 'Groups'
    this.link = 'groupDetail'
    this.glyph = 'comment'
    if (this.entity) {
      this.info = {
        City: this.entity.city,
        State: this.entity.city.state,
        Interest: this.entity.interest
      }
      this.setInfo = {
        Members: this.members
      }
    }
  }

  getLink (name) {
    if (name === 'State') {
      return 'stateDetail'
    } else if (name === 'City') {
      return 'cityDetail'
    } else if (name === 'Members') {
      return 'personDetail'
    } else if (name === 'Interest') {
      return 'interestDetail'
    }
  }

  getGlyph (name) {
    if (name === 'State') {
      return 'flag'
    } else if (name === 'City') {
      return 'home'
    } else if (name === 'Members') {
      return 'user'
    } else if (name === 'Interest') {
      return 'heart'
    }
  }
}