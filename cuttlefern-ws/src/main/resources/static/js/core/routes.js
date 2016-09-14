angular
		.module('app')
		.config(
				[
						'$routeProvider',
						'baseRoute',
						'homePage',
						function config($routeProvider, baseRoute, homePage) {

							$routeProvider
									.when('/home', {

										templateUrl : homePage,
										controller : 'HomeController',
										controllerAs : 'homeController'

									})

									.when(
											'/person',
											{

												templateUrl : baseRoute
														+ 'person/personTemplate.html',
												controller : 'PersonController',
												controllerAs : 'personController',
												resolve : {
													allPeople : function(
															PersonService) {
														return PersonService
																.getAllPeople();
													}
												}

											})
									.when(

											'/person/:id',
											{

												templateUrl : baseRoute
														+ 'person/personDetailTemplate.html',
												controller : 'PersonDetailController',
												controllerAs : 'personDetailController'
											})

									.when(
											'/interest',
											{

												templateUrl : baseRoute
														+ 'interest/interestTemplate.html',
												controller : 'InterestController',
												controllerAs : 'interestController',
												resolve : {
													allInterests : function(
															InterestService) {
														return InterestService
																.getAllInterests();
													}
												}

											})
									.when(

											'/interest/:id',
											{

												templateUrl : baseRoute
														+ 'interest/interestDetailTemplate.html',
												controller : 'InterestDetailController',
												controllerAs : 'interestDetailController'
											})

									.when(
											'/city',
											{

												templateUrl : baseRoute
														+ 'city/cityTemplate.html',
												controller : 'CityController',
												controllerAs : 'cityController',
												resolve : {
													allCities : function(
															CityService) {
														return CityService
																.getAllCities();
													}
												}

											})
									.when(

											'/city/:id',
											{

												templateUrl : baseRoute
														+ 'city/cityDetailTemplate.html',
												controller : 'CityDetailController',
												controllerAs : 'cityDetailController'
											})

									.when(
											'/state',
											{

												templateUrl : baseRoute
														+ 'state/stateTemplate.html',
												controller : 'StateController',
												controllerAs : 'stateController',
												resolve : {
													allStates : function(
															StateService) {
														return StateService
																.getAllStates();
													}
												}

											})
									.when(

											'/state/:id',
											{

												templateUrl : baseRoute
														+ 'state/stateDetailTemplate.html',
												controller : 'StateDetailController',
												controllerAs : 'stateDetailController'
											})

									.when(
											'/group',
											{

												templateUrl : baseRoute
														+ 'group/groupTemplate.html',
												controller : 'GroupController',
												controllerAs : 'groupController',
												resolve : {
													allGroups : function(
															GroupService) {
														return GroupService
																.getAllGroups();
													}
												}

											})
									.when(

											'/group/:id',
											{

												templateUrl : baseRoute
														+ 'group/groupDetailTemplate.html',
												controller : 'GroupDetailController',
												controllerAs : 'groupDetailController'
											})

									.otherwise('/home');

						} ]);