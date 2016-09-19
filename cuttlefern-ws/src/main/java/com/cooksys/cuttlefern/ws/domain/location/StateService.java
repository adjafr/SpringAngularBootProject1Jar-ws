package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;



public interface StateService {
	
	State create(State state);

	List<State> index();

	State read(State state);

	State update(Integer id, State stateToUpdate);

	State delete(State state);
	
	Set<City> cities(State state);

	Set<Person> people(State state);

	Set<Group> groups(State state);

	Set<Interest> interests(State state);

	Set<City> interesetCities(State state, Interest interest);

	Set<Person> interesetPeople(State state, Interest interest);

	Set<Group> interesetGroups(State state, Interest interest);

}
