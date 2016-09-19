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
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/interests")
public class InterestController {
	
	private final InterestService service;
	
	@Autowired
	public InterestController(InterestService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Interest create(@RequestBody Interest interest) {
		return this.service.create(interest);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Interest> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{interest}", method=RequestMethod.GET)
	public Interest read(@PathVariable Interest interest) {
		return this.service.read(interest);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Interest, or just old Interest
	public Interest update(@PathVariable Integer id, @RequestBody Interest interestToUpdate) {
		return this.service.update(id, interestToUpdate);
	}
	
	@RequestMapping(value="{interest}", method=RequestMethod.DELETE) // Return old and new Interest, or just old Interest
	public Interest delete(@PathVariable Interest interest) {
		return this.service.delete(interest);
	} 
	
	
	@RequestMapping(value = "{interest}/people", method = RequestMethod.GET)
	public Set<Person> people(@PathVariable Interest interest) {
		return this.service.people(interest);
	}
	
	@RequestMapping(value = "{interest}/groups", method = RequestMethod.GET)
	public Set<Group> groups(@PathVariable Interest interest) {
		return this.service.groups(interest);
	}
	
	@RequestMapping(value = "{interest}/cities", method = RequestMethod.GET)
	public Set<City> cities(@PathVariable Interest interest) {
		return this.service.cities(interest);
	}
	
	@RequestMapping(value = "{interest}/states", method = RequestMethod.GET)
	public Set<State> states(@PathVariable Interest interest) {
		return this.service.states(interest);
	}
	
}
