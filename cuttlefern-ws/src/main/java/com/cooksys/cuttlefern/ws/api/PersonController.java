package com.cooksys.cuttlefern.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;



@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/people")
public class PersonController {
	
private final PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return this.service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{person}", method=RequestMethod.GET)
	public Person read(@PathVariable Person person) {
		return this.service.read(person);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Person, or just old Person
	public Person update(@PathVariable Integer id, @RequestBody Person personToUpdate) {
		return this.service.update(id, personToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new Person, or just old Person
	public Person delete(@PathVariable Person person) {
		return this.service.delete(person);
	} 
	
	@RequestMapping(value = "{person}/city", method = RequestMethod.GET)
	public City readCity(@PathVariable Person person) {
		return this.service.readCity(person);
	}
	
	@RequestMapping(value = "{person}/city", method = RequestMethod.PUT)
	public City updateCity(@PathVariable Person person, @RequestBody City city) {
		return this.service.updateCity(person, city);
	}
	
	@RequestMapping(value = "{person}/interests", method = RequestMethod.GET)
	public Set<Interest> readInterests(@PathVariable Person person) {
		return this.service.readInterests(person);
	}
	
	@RequestMapping(value = "{person}/interests", method = RequestMethod.PUT)
	public Set<Interest> updateInterests(@PathVariable Person person, @RequestBody Set<Interest> interests) {
		return this.service.updateInterests(person, interests);
	}
	
	@RequestMapping(value = "{person}/interests/{interest}", method = RequestMethod.DELETE)
	public Interest deleteInterest(@PathVariable Person person, @PathVariable Interest interest) {
		return this.service.deleteInterest(person, interest);
	}
	
	@RequestMapping(value = "{person}/groups", method = RequestMethod.GET)
	public Set<Group> readGroups(@PathVariable Person person) {
		return this.service.readGroups(person);
	}
	
	@RequestMapping(value = "{person}/groups", method = RequestMethod.PUT)
	public Set<Group> updateGroups(@PathVariable Person person, @RequestBody Set<Group> groups) {
		return this.service.updateGroups(person, groups);
	}
	
	@RequestMapping(value = "{person}/groups/{gId}", method = RequestMethod.DELETE)
	public Group deleteGroup(@PathVariable Person person, @PathVariable Group group) {
		return this.service.deleteGroup(person, group);
	}

}
