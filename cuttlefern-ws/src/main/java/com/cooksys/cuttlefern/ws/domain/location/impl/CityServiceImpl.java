package com.cooksys.cuttlefern.ws.domain.location.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityRepository;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateRepository;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository repo;
	private StateRepository stateRepo;

	@Autowired
	public CityServiceImpl(CityRepository repo) {
		super();
		this.repo = repo;
	}
	

	
	@Override
	public City create(City city) {
		return this.repo.save(city);
	}

	@Override
	public List<City> index() {
		return this.repo.findAll();
	}

	@Override
	public City read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public City update(Integer id, City cityToUpdate) {
		cityToUpdate.setId(id);
		return this.repo.save(cityToUpdate);
	}

	@Override
	public City delete(Integer id) {
		City result = this.read(id);
		this.repo.delete(id);
		return result;
	}


	@Override
	public State readState(Integer id)
	{
		return this.repo.findOne(id).getState();
	}


	@Override
	public City updateState(Integer id, State stateToUpdate)
	{
		City result = this.read(id);
		result.setState(stateToUpdate);
		return this.repo.save(result);
//		result = this.repo.findOne(id).setState(stateToUpdate);
//		return this.repo.saveAndFlush(id);  // return this.repo.findOne(id).getState();		
	}
	
	
	
	
	
}
