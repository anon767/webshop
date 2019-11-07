package com.hska.webshop.user.repository;

import org.openapitools.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/*
public interface UserRepository extends CrudRepository<User, Integer>{	
    @Query("FROM User u WHERE LOWER(u.username) LIKE LOWER(?1)")
    Iterable<User> getUserByUsername(String username);
}
*/

public interface UserRepository extends CrudRepository<User, Integer>{	

}