package com.aijaycodes.movieApp.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieData, Long> {
	
	@Query(value="SELECT title FROM movie", nativeQuery = true)
	public  List<String> getMovies();

}
