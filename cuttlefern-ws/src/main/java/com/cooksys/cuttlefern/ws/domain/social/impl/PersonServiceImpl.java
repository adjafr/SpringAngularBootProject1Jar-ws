package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestRepository;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityRepository;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepo;
	
	private final CityRepository cityRepo;
	
	private final InterestRepository interestRepo;
	
	private final GroupRepository groupRepo;


	@Autowired
	public PersonServiceImpl(PersonRepository personRepo, CityRepository cityRepo, InterestRepository interestRepo,
			GroupRepository groupRepo) {
		super();
		this.personRepo = personRepo;
		this.cityRepo = cityRepo;
		this.interestRepo = interestRepo;
		this.groupRepo = groupRepo;
	}
	
	
	@Override
	public Person create(Person person) {
		return this.personRepo.save(person);
	}

	@Override
	public List<Person> index() {
		return this.personRepo.findAll();
	}

	@Override
	public Person read(Person person) {
		return person;
	}

	@Override
	public Person update(Integer id, Person personToUpdate) {
		personToUpdate.setId(id);
		return this.personRepo.save(personToUpdate);
	}

	@Override
	public Person delete(Person person) {
		for (Interest interest : person.getInterests()) {
			interest.getPeople().remove(person);
			this.interestRepo.save(interest);
		}
		for (Group group: person.getGroups()) {
			group.getMembers().remove(person);
			this.groupRepo.save(group);
		}
		this.personRepo.delete(person);
		return person;
	}

	@Override
	public City readCity(Person person) {
		return person.getCity();
	}

	@Override
	public City updateCity(Person person, City city) {
		person.setCity(this.cityRepo.findOne(city.getId()));
		return this.personRepo.save(person).getCity();
	}

	@Override
	public Set<Interest> readInterests(Person person) {
		return person.getInterests();
	}

	@Override
	public Set<Interest> updateInterests(Person person, Set<Interest> interests) {
		for (Interest i : interests) {
			Interest interest = interestRepo.findOne(i.getId());
			if (!person.getInterests().contains(interest)) {
				person.getInterests().add(interest);
			}
		}
		return this.personRepo.save(person).getInterests();
	}

	@Override
	public Interest deleteInterest(Person person, Interest interest) {
		person.getInterests().remove(interest);
		this.personRepo.save(person);
		return interest;
	}

	@Override
	public Set<Group> readGroups(Person person) {
		return person.getGroups();
	}

	@Override
	public Set<Group> updateGroups(Person person, Set<Group> groups) {
		for (Group g : groups) {
			Group group = groupRepo.findOne(g.getId());
			if (!group.getMembers().contains(person) && person.getInterests().contains(group.getInterest()) &&
					person.getCity().equals(group.getCity())) {
				group.getMembers().add(person);
			}
			this.groupRepo.save(group);
		}
		return person.getGroups();
	}

	@Override
	public Group deleteGroup(Person person, Group group) {
		group.getMembers().remove(person);
		this.groupRepo.save(group);
		return group;
	}
	
}
