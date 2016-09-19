export default class InterestController {
  /* @ngInject */
  constructor () {
    this.name = 'Interests'
    this.link = 'interestDetail'
    this.glyph = 'heart'
    if (this.entity) {
      this.info = {
      }
      this.setInfo = {
        Groups: this.groups,
        People: this.people,
        Cities: this.cities,
        States: this.states
      }
    }
  }

  getLink (name) {
    if (name === 'States') {
      return 'stateDetail'
    } else if (name === 'Cities') {
      return 'cityDetail'
    } else if (name === 'People') {
      return 'personDetail'
    } else if (name === 'Groups') {
      return 'groupDetail'
    }
  }

  getGlyph (name) {
    if (name === 'States') {
      return 'flag'
    } else if (name === 'Cities') {
      return 'home'
    } else if (name === 'People') {
      return 'user'
    } else if (name === 'Groups') {
      return 'comment'
    }
  }
}