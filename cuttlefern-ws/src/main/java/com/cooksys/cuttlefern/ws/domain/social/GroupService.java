package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;



public interface GroupService {
	
	Group create(Group group);

	List<Group> index();

	Group read(Group group);

	Group update(Integer id, Group groupToUpdate);

	Group delete(Group group);
	

	City readCity(Group group);

	City updateCity(Group group, City city);

	Interest readInterest(Group group);

	Interest updateInterest(Group group, Interest interest);

	Set<Person> readMembers(Group group);

	Set<Person> updateMembers(Group group, Set<Person> members);

	Person deleteMembers(Group group, Person member);

}
