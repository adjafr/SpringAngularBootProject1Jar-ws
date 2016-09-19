export default class CityController {
  /* @ngInject */
  constructor () {
    this.name = 'Cities'
    this.link = 'cityDetail'
    this.glyph = 'home'
    if (this.entity) {
      this.info = {
        State: this.entity.state
      }
      this.setInfo = {
        People: this.people,
        Groups: this.groups,
        Interests: this.interests
      }
    }
  }

  getLink (name) {
    if (name === 'State') {
      return 'stateDetail'
    } else if (name === 'People') {
      return 'personDetail'
    } else if (name === 'Groups') {
      return 'groupDetail'
    } else if (name === 'Interests') {
      return 'interestDetail'
    }
  }

  getGlyph (name) {
    if (name === 'State') {
      return 'flag'
    } else if (name === 'People') {
      return 'user'
    } else if (name === 'Groups') {
      return 'comment'
    } else if (name === 'Interests') {
      return 'heart'
    }
  }
}