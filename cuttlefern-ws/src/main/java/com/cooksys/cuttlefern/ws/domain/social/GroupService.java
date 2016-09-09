package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;



public interface GroupService {
	
	Group create(Group group);

	List<Group> index();

	Group read(Integer id);

	Group update(Integer id, Group groupToUpdate);

	Group delete(Integer id);

}
