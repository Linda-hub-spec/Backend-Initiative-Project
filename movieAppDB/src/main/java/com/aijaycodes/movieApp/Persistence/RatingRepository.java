package com.aijaycodes.movieApp.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<RatingsData, Long>{
	
	@Query(value="SELECT movieId, rating FROM ratings", nativeQuery = true)
	public  List<RatingResponse> getRatings();

}
