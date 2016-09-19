export default class CityController {
  /* @ngInject */
  constructor () {
    this.name = 'States'
    this.link = 'stateDetail'
    this.glyph = 'flag'
    if (this.entity) {
      this.info = {
      }
      this.setInfo = {
        Cities: this.cities,
        Interests: this.interests,
        Groups: this.groups,
        People: this.people
      }
    }
  }

  getLink (name) {
    if (name === 'Cities') {
      return 'citiesDetail'
    } else if (name === 'People') {
      return 'personDetail'
    } else if (name === 'Groups') {
      return 'groupDetail'
    } else if (name === 'Interests') {
      return 'interestDetail'
    }
  }

  getGlyph (name) {
    if (name === 'Cities') {
      return 'home'
    } else if (name === 'People') {
      return 'user'
    } else if (name === 'Groups') {
      return 'comment'
    } else if (name === 'Interests') {
      return 'heart'
    }
  }
}