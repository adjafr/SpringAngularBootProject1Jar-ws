package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;




public interface CityService {
	
	City create(City group);

	List<City> index();

	City read(City city);

	City update(Integer id, City cityToUpdate);

	City delete(City city);

	State readState(City city);

	State updateState(City city, State state);
	
	Set<Person> people(City city);

	Set<Group> groups(City city);

	Set<Interest> interests(City city);

	Set<Person> interestPeople(City city, Interest interest);

	Set<Group> interestGroups(City city, Interest interest);

}
