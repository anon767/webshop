package com.hska.webshop.role.repository;

import org.openapitools.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer>{	
	@Query("FROM Role r WHERE r.level = ?1")
	Iterable<Role> getRolesByLevel(Integer level); 
}
