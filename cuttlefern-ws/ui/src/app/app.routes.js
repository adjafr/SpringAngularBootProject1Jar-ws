export default function routes ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('home')

  $stateProvider
    .state('home', {
      url: '/home',
      template: '<app-home></app-home>'
    })
}