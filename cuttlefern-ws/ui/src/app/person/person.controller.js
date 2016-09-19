export default class PersonController {
  /* @ngInject */
  constructor () {
    this.name = 'People'
    this.link = 'personDetail'
    this.glyph = 'user'
    if (this.entity) {
      this.info = {
        City: this.entity.city,
        State: this.entity.city.state
      }
      this.setInfo = {
        Interests: this.entity.interests,
        Groups: this.entity.groups
      }
    }
  }

  getLink (name) {
    if (name === 'State') {
      return 'stateDetail'
    } else if (name === 'City') {
      return 'cityDetail'
    } else if (name === 'Groups') {
      return 'groupDetail'
    } else if (name === 'Interests') {
      return 'interestDetail'
    }
  }

  getGlyph (name) {
    if (name === 'State') {
      return 'flag'
    } else if (name === 'City') {
      return 'home'
    } else if (name === 'Groups') {
      return 'comment'
    } else if (name === 'Interests') {
      return 'heart'
    }
  }
}