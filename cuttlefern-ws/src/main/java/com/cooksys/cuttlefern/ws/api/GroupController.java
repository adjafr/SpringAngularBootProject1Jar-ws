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
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;



@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/groups")
public class GroupController {
	
private final GroupService service;
	
	@Autowired
	public GroupController(GroupService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Group create(@RequestBody Group group) {
		return this.service.create(group);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Group> index() {
		return this.service.index();
	}
	
	@RequestMapping(value="{group}", method=RequestMethod.GET)
	public Group read(@PathVariable Group group) {
		return this.service.read(group);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PATCH) // Return old and new Group, or just old Group
	public Group update(@PathVariable Integer id, @RequestBody Group groupToUpdate) {
		return this.service.update(id, groupToUpdate);
	}
	
	@RequestMapping(value="{group}", method=RequestMethod.DELETE) // Return old and new Group, or just old Group
	public Group delete(@PathVariable Group group) {
		return this.service.delete(group);
	} 
	
	@RequestMapping(value = "{group}/city", method = RequestMethod.GET)
	public City readCity(@PathVariable Group group) {
		return this.service.readCity(group);
	}
	
	@RequestMapping(value = "{group}/city", method = RequestMethod.PUT)
	public City updateCity(@PathVariable Group group, @RequestBody City city) {
		return this.service.updateCity(group, city);
	}
	
	@RequestMapping(value = "{group}/interest", method = RequestMethod.GET)
	public Interest readInterest(@PathVariable Group group) {
		return this.service.readInterest(group);
	}
	
	@RequestMapping(value = "{group}/interest", method = RequestMethod.PUT)
	public Interest updateInterest(@PathVariable Group group, @RequestBody Interest interest) {
		return this.service.updateInterest(group, interest);
	}
	
	@RequestMapping(value = "{group}/members", method = RequestMethod.GET)
	public Set<Person> readMambers(@PathVariable Group group) {
		return this.service.readMembers(group);
	}
	
	@RequestMapping(value = "{group}/members", method = RequestMethod.PUT)
	public Set<Person> updateMembers(@PathVariable Group group, @RequestBody Set<Person> members) {
		return this.service.updateMembers(group, members);
	}
	
	@RequestMapping(value = "{group}/members/{mId}", method = RequestMethod.DELETE)
	public Person deleteMembers(@PathVariable Group group, @PathVariable Person mId) {
		return this.service.deleteMembers(group, mId);
	}

}
