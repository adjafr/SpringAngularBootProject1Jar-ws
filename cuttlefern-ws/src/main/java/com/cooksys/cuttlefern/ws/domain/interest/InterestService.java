package com.cooksys.cuttlefern.ws.domain.interest;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;

public interface InterestService {

	Interest create(Interest interest);

	List<Interest> index();

	Interest read(Interest interest);

	Interest update(Integer id, Interest interestToUpdate);

	Interest delete(Interest interest);
	
	
	Set<Person> people(Interest interest);

	Set<Group> groups(Interest interest);

	Set<City> cities(Interest interest);

	Set<State> states(Interest interest);

}
