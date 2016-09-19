package com.cooksys.cuttlefern.ws.domain.location.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateRepository;
import com.cooksys.cuttlefern.ws.domain.location.StateService;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;

@Service
public class StateServiceImpl implements StateService {

	private final StateRepository repo;

	@Autowired
	public StateServiceImpl(StateRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	@Override
	public State create(State state) {
		return this.repo.save(state);
	}

	@Override
	public List<State> index() {
		return this.repo.findAll();
	}

	@Override
	public State read(State state) {
		return state;
	}

	@Override
	public State update(Integer id, State stateToUpdate) {
		stateToUpdate.setId(id);
		return this.repo.save(stateToUpdate);
	}

	@Override
	public State delete(State state) {
//		State result = this.read(id);
		this.repo.delete(state);
		return state;   //result;
	}
	
	@Override
	public Set<City> cities(State state) {
		return state.getCities();
	}

	@Override
	public Set<Person> people(State state) {
		Set<Person> people = new HashSet<>();
		for (City city : state.getCities()) {
			for (Person person : city.getPeople()) {
				people.add(person);
			}
		}
		return people;
	}

	@Override
	public Set<Group> groups(State state) {
		Set<Group> groups = new HashSet<>();
		for (City city : state.getCities()) {
			for (Group group : city.getGroups()) {
				groups.add(group);
			}
		}
		return groups;
	}

	@Override
	public Set<Interest> interests(State state) {
		Set<Interest> interests = new HashSet<>();
		for (City city : state.getCities()) {
			for (Person person : city.getPeople()) {
				for (Interest interest : person.getInterests()) {
					if (!interests.contains(interest)) {
						interests.add(interest);
					}
				}
			}
			for (Group group : city.getGroups()) {
				if (!interests.contains(group.getInterest())) {
					interests.add(group.getInterest());
				}
			}
		}
		return interests;
	}

	@Override
	public Set<City> interesetCities(State state, Interest interest) {
		Set<City> cities = new HashSet<>();
		for (Person person : interest.getPeople()) {
			if (person.getCity().getState().equals(state) && !cities.contains(person.getCity())) {
				cities.add(person.getCity());
			}
		}
		for (Group group : interest.getGroups()) {
			if (group.getCity().getState().equals(state) && !cities.contains(group.getCity())) {
				cities.add(group.getCity());
			}
		}
		return cities;
	}

	@Override
	public Set<Person> interesetPeople(State state, Interest interest) {
		Set<Person> people = new HashSet<>();
		for (Person person : interest.getPeople()) {
			if(person.getCity().getState().equals(state)) {
				people.add(person);
			}
		}
		return people;
	}

	@Override
	public Set<Group> interesetGroups(State state, Interest interest) {
		Set<Group> groups = new HashSet<>();
		for (Group group : interest.getGroups()) {
			if(group.getCity().getState().equals(state)) {
				groups.add(group);
			}
		}
		return groups;
	}

	
	
}
