package com.aijaycodes.movieApp.Persistence;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserData, Long> {
	
	@Query(value="SELECT name FROM users", nativeQuery = true)
	public  List<String> getUsers();

}
