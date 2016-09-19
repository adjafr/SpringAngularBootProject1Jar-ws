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
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;

@Service
public class GroupServiceImpl implements GroupService {
	
	private final GroupRepository groupRepo;
	
	private final CityRepository cityRepo;
	
	private final InterestRepository interestRepo;
	
	private final PersonRepository personRepo;
	
	@Autowired
	public GroupServiceImpl(GroupRepository groupRepo, CityRepository cityRepo, InterestRepository interestRepo,
			PersonRepository personRepo) {
		super();
		this.groupRepo = groupRepo;
		this.cityRepo = cityRepo;
		this.interestRepo = interestRepo;
		this.personRepo = personRepo;
	}
	
	
	@Override
	public Group create(Group group) {
		return this.groupRepo.save(group);
	}

	@Override
	public List<Group> index() {
		return this.groupRepo.findAll();
	}

	@Override
	public Group read(Group group) {
		return group;    //this.groupRepo.findOne(id);
	}

	@Override
	public Group update(Integer id, Group groupToUpdate) {
		groupToUpdate.setId(id);
		return this.groupRepo.save(groupToUpdate);
	}

	@Override
	public Group delete(Group group) {
		for (Person person : group.getMembers()) {
			person.getGroups().remove(group);
			this.personRepo.save(person);
		}
		group.getInterest().getGroups().remove(group);
		this.interestRepo.save(group.getInterest());
		this.groupRepo.delete(group);
		return group;
	}

	@Override
	public City readCity(Group group) {
		return group.getCity();
	}

	@Override
	public City updateCity(Group group, City city) {
		group.setCity(this.cityRepo.findOne(city.getId()));
		return this.groupRepo.save(group).getCity();
	}

	@Override
	public Interest readInterest(Group group) {
		return group.getInterest();
	}

	@Override
	public Interest updateInterest(Group group, Interest interest) {
		group.setInterest(this.interestRepo.findOne(interest.getId()));
		return this.groupRepo.save(group).getInterest();
	}

	@Override
	public Set<Person> readMembers(Group group) {
		return group.getMembers();
	}

	@Override
	public Set<Person> updateMembers(Group group, Set<Person> members) {
		for (Person p : members) {
			Person person = this.personRepo.findOne(p.getId());
			if (person.getCity().equals(group.getCity()) && person.getInterests().contains(group.getInterest())) {
				group.getMembers().add(person);
			}
		}
		this.groupRepo.save(group);
		return group.getMembers();
	}

	@Override
	public Person deleteMembers(Group group, Person mId) {
		group.getMembers().remove(mId);
		this.groupRepo.save(group);
		return mId;
	}
	
	
}
