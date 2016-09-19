package com.cooksys.cuttlefern.ws.domain.location.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityRepository;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateRepository;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepo;
	private final StateRepository stateRepo;

	@Autowired
	public CityServiceImpl(CityRepository cityRepo, StateRepository stateRepo) {
		super();
		this.cityRepo = cityRepo;
		this.stateRepo = stateRepo;
	}
	

	
	@Override
	public City create(City city) {
		return this.cityRepo.save(city);
	}

	@Override
	public List<City> index() {
		return this.cityRepo.findAll();
	}

	@Override
	public City read(City city) {
		return city;    //this.repo.findOne(id);
	}

	@Override
	public City update(Integer id, City cityToUpdate) {
		cityToUpdate.setId(id);
		return this.cityRepo.save(cityToUpdate);
	}

	@Override
	public City delete(City city) {
		//City result = this.read(id);
		this.cityRepo.delete(city);
		return city;   // result;
	}


	@Override
	public State readState(City city)
	{
		return city.getState();     //this.repo.findOne(id).getState();
	}


	@Override
	public State updateState(City city, State state)
	{
		//City result = this.read(city);
		city.setState(this.stateRepo.findOne(state.getId()));           //result.setState(stateToUpdate);
		return this.cityRepo.save(city).getState();    //return this.repo.save(result);
//		result = this.repo.findOne(id).setState(stateToUpdate);
//		return this.repo.saveAndFlush(id);  // return this.repo.findOne(id).getState();		
	}
	
	@Override
	public Set<Person> people(City city) {
		return city.getPeople();
	}

	@Override
	public Set<Group> groups(City city) {
		return city.getGroups();
	}

	@Override
	public Set<Interest> interests(City city) {
		Set<Interest> interests = new HashSet<>();
		for (Person p : city.getPeople()) {
			for (Interest interest : p.getInterests()) {
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
		return interests;
	}

	@Override
	public Set<Person> interestPeople(City city, Interest interest) {
		Set<Person> people = new HashSet<>();
		for (Person person : interest.getPeople()) {
			if (person.getCity().equals(city)) {
				people.add(person);
			}
		}
		return people;
	}

	@Override
	public Set<Group> interestGroups(City city, Interest interest) {
		Set<Group> groups = new HashSet<>();
		for (Group group : interest.getGroups()) {
			if(group.getCity().equals(city)) {
				groups.add(group);
			}
		}
		return groups;
	}
	
	
	
}
