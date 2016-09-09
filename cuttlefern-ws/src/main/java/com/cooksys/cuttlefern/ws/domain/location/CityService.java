package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;




public interface CityService {
	
	City create(City group);

	List<City> index();

	City read(Integer id);

	City update(Integer id, City cityToUpdate);

	City delete(Integer id);

	State readState(Integer id);

	City updateState(Integer id, State stateToUpdate);

}
