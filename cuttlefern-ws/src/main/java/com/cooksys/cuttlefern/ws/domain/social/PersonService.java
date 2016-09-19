package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.interest.Interest;



public interface PersonService {
	
	Person create(Person person);

	List<Person> index();

	Person read(Person person);

	Person update(Integer id, Person personToUpdate);

	Person delete(Person person);
	
	City readCity(Person person);

	City updateCity(Person person, City city);

	Set<Interest> readInterests(Person person);

	Set<Interest> updateInterests(Person person, Set<Interest> interests);

	Interest deleteInterest(Person person, Interest interest);

	Set<Group> readGroups(Person person);

	Set<Group> updateGroups(Person person, Set<Group> groups);

	Group deleteGroup(Person person, Group gId);

}
