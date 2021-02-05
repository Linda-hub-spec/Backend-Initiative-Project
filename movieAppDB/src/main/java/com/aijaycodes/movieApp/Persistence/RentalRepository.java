package com.aijaycodes.movieApp.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<RentalData, Long>{
	
	@Query(value="SELECT movieId, rating FROM ratings", nativeQuery = true)
	public  List<RentalResponse> getRentals();

}
