package com.cooksys.cuttlefern.ws.domain.interest.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestRepository;
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;

@Service
public class InterestServiceImpl implements InterestService {

	private final InterestRepository interestRepo;
	
	private final PersonRepository personRepo;

	@Autowired
	public InterestServiceImpl(InterestRepository interestRepo, PersonRepository personRepo) {
		super();
		this.interestRepo = interestRepo;
		this.personRepo = personRepo;
	}

	@Override
	public Interest create(Interest interest) {
		return this.interestRepo.save(interest);
	}

	@Override
	public List<Interest> index() {
		return this.interestRepo.findAll();
	}

	@Override
	public Interest read(Interest interest) {
		return interest;    //this.interestRepo.findOne(id);
	}

	@Override
	public Interest update(Integer id, Interest interestToUpdate) {
		interestToUpdate.setId(id);
		return this.interestRepo.save(interestToUpdate);
	}

	
	@Override
	public Interest delete(Interest interest) {
		for (Person person : interest.getPeople()) {
			person.getInterests().remove(interest);
			this.personRepo.save(person);
		}
		this.interestRepo.delete(interest);
		return interest;
	}

	@Override
	public Set<Person> people(Interest interest) {
		return interest.getPeople();
	}

	@Override
	public Set<Group> groups(Interest interest) {
		return interest.getGroups();
	}

	@Override
	public Set<City> cities(Interest interest) {
		Set<City> cities = new HashSet<>();
		for (Person person : interest.getPeople()) {
			if (!cities.contains(person.getCity())) {
				cities.add(person.getCity());
			}
		}
		for (Group group : interest.getGroups()) {
			if (!cities.contains(group.getCity())) {
				cities.add(group.getCity());
			}
		}
		return cities;
	}

	@Override
	public Set<State> states(Interest interest) {
		Set<State> states = new HashSet<>();
		for (Person person : interest.getPeople()) {
			if (!states.contains(person.getCity().getState())) {
				states.add(person.getCity().getState());
			}
		}
		for (Group group : interest.getGroups()) {
			if (!states.contains(group.getCity())) {
				states.add(group.getCity().getState());
			}
		}
		return states;
	}
}
