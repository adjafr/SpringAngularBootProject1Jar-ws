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
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateService;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;



@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/states")
public class StateController {
	
private final StateService service;
	
	@Autowired
	public StateController(StateService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public State create(@RequestBody State state) {
		return this.service.create(state);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<State> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{state}", method=RequestMethod.GET)
	public State read(@PathVariable State state) {
		return this.service.read(state);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new State, or just old State
	public State update(@PathVariable Integer id, @RequestBody State stateToUpdate) {
		return this.service.update(id, stateToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new State, or just old State
	public State delete(@PathVariable State state) {
		return this.service.delete(state);
	}  
	
	@RequestMapping(value = "{state}/cities", method = RequestMethod.GET)
	public Set<City> cities(@PathVariable State state) {
		return this.service.cities(state);
	}
	
	@RequestMapping(value = "{state}/people", method = RequestMethod.GET)
	public Set<Person> people(@PathVariable State state) {
		return this.service.people(state);
	}
	
	@RequestMapping(value = "{state}/groups", method = RequestMethod.GET)
	public Set<Group> groups(@PathVariable State state) {
		return this.service.groups(state);
	}
	
	@RequestMapping(value = "{state}/interests", method = RequestMethod.GET)
	public Set<Interest> interests(@PathVariable State state) {
		return this.service.interests(state);
	}
	
	@RequestMapping(value = "{state}/interests/{interest}/cities", method = RequestMethod.GET)
	public Set<City> interestCities(@PathVariable State state, @PathVariable Interest interest) {
		return this.service.interesetCities(state, interest);
	}
	
	@RequestMapping(value = "{state}/interests/{interest}/people", method = RequestMethod.GET)
	public Set<Person> interestPeople(@PathVariable State state, @PathVariable Interest interest) {
		return this.service.interesetPeople(state, interest);
	}
	
	@RequestMapping(value = "{state}/interests/{interest}/groups", method = RequestMethod.GET)
	public Set<Group> interestGroups(@PathVariable State state, @PathVariable Interest interest) {
		return this.service.interesetGroups(state, interest);
	}

}
