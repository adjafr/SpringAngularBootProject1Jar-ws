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
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.Person;


@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/cities")
public class CityController {
	
private final CityService service;
	
	@Autowired
	public CityController(CityService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public City create(@RequestBody City city) {
		return this.service.create(city);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<City> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{city}", method=RequestMethod.GET)
	public City read(@PathVariable City city) {
		return this.service.read(city);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new City, or just old City
	public City update(@PathVariable Integer id, @RequestBody City cityToUpdate) {
		return this.service.update(id, cityToUpdate);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) // Return old and new City, or just old City
	public City delete(@PathVariable City city) {
		return this.service.delete(city);
	} 
	
	
	@RequestMapping(value="{city}/state", method=RequestMethod.GET)
	public State readState(@PathVariable City city) {
		return this.service.readState(city);
	}
	
	
	@RequestMapping(value="{city}/state", method=RequestMethod.PUT) // Return old and new State, or just old State
	public State updateState(@PathVariable City city, @RequestBody State state) {  //stateToUpdate
		return this.service.updateState(city, state);   //stateToUpdate
	}
	
	@RequestMapping(value = "{city}/people", method = RequestMethod.GET)
	public Set<Person> people(@PathVariable City city) {
		return this.service.people(city);
	}
	
	@RequestMapping(value = "{city}/groups", method = RequestMethod.GET)
	public Set<Group> groups(@PathVariable City city) {
		return this.service.groups(city);
	}
	
	@RequestMapping(value = "{city}/interests", method = RequestMethod.GET)
	public Set<Interest> interests(@PathVariable City city) {
		return this.service.interests(city);
	}
	
	@RequestMapping(value = "{city}/interests/{interest}/people", method = RequestMethod.GET)
	public Set<Person> interestPeople(@PathVariable City city, @PathVariable Interest interest) {
		return this.service.interestPeople(city, interest);
	}
	
	@RequestMapping(value = "{city}/interests/{interest}/groups", method = RequestMethod.GET)
	public Set<Group> interestGroups(@PathVariable City city, @PathVariable Interest interest) {
		return this.service.interestGroups(city, interest);
	}
	
	
}