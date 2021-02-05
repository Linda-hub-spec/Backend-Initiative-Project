package com.aijaycodes.movieApp.service;

import java.util.List;

import com.aijaycodes.movieApp.Persistence.MovieData;
import com.aijaycodes.movieApp.Persistence.RatingsData;
import com.aijaycodes.movieApp.Persistence.RentalData;
import com.aijaycodes.movieApp.Persistence.UserData;

public interface MovieService {
	
	 List<UserData> getUsers();
	 
	 List<RentalData> getRentals();
	 
	 List<RatingsData> getRatings();
	 
	 List<MovieData> getMovies();
	 
	 Object deleteRentals(String id);

	 Object deleteRating(String id);
	 
	 Object deleteUser(String id);
	 
	 Object deleteMovie(String id);
	 
	 Object updateUser(String id,UserData data);
	 
	 Object updateRentals(String id,RentalData data);
	 
	 Object updateRatings(String id,RatingsData data);
	 
	 Object updateMovie(String id, MovieData data);
	 
	 Object createRental(RentalData data);
	 
	 Object createRating(RatingsData data);
	 
	 Object createUser(UserData data);
	 
	 Object createMovie(MovieData data);

}
