package com.aijaycodes.movieApp.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aijaycodes.movieApp.Persistence.MovieData;
import com.aijaycodes.movieApp.Persistence.RatingsData;
import com.aijaycodes.movieApp.Persistence.RentalData;
import com.aijaycodes.movieApp.Persistence.Response;
import com.aijaycodes.movieApp.Persistence.UserData;
import com.aijaycodes.movieApp.service.MovieService;

@RestController
@RequestMapping("/movieApp")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	

	 
	@GetMapping("/users")
	 public List<UserData> getUsers() {
		 
		 List<UserData> responseData = new ArrayList<>();
		 responseData = service.getUsers();
		 
		 return responseData;
	 }
	
	@GetMapping("/rentals")
	 public List<RentalData> getRentals(){
		 List<RentalData> responseData = new ArrayList<>();
		 responseData = service.getRentals();
		 
		 return responseData;
	 }
	 
	@GetMapping("/ratings")
	 public List<RatingsData> getRatings(){
		 List<RatingsData> responseData = new ArrayList<>();
		 responseData = service.getRatings();
		 
		 return responseData;
	 }
	 
	@GetMapping("/movies")
	 public List<MovieData> getMovies(){
		 List<MovieData> responseData = new ArrayList<>();
		 responseData = service.getMovies();
		 
		 return responseData;
	 }
	
	@PostMapping("/deleteRental/{rentalId}")
	public Object deleteRental(@PathVariable("rentalId") String id) {
		
		return service.deleteRentals(id);
		
	}
	
	@PostMapping("/deleteRating/{ratingId}")
	public Object deleteRating(@PathVariable("ratingId") String id) {
		
		return service.deleteRating(id);
		
	}
	
	
	@PostMapping("/deleteMovie/{movieId}")
	public Object deleteMovie(@PathVariable("movieId") String id) {
		
		return service.deleteMovie(id);
		
	}
	
	@PostMapping("/deleteUser/{userId}")
	public Object deleteUser(@PathVariable("userId") String userId) {
		
		return service.deleteUser(userId);
		
	}
	 
	@PostMapping("/updateUser/{id}")
	public Object updateUser(@PathVariable("id") String id,@RequestBody UserData data) {
		return service.updateUser(id,data);
	}
	
	@PostMapping("/updateRental/{id}")
	public Object updateRental(@PathVariable("id") String id, @RequestBody RentalData data) {
		return service.updateRentals(id, data);
	}
	
	@PostMapping("/updateRating/{id}")
	public Object updateRating(@PathVariable("id") String id, @RequestBody RatingsData data) {
		return service.updateRatings(id, data);
	}
	
	@PostMapping("/updateMovie/{id}")
	public Object updateMovie(@PathVariable("id") String id, @RequestBody MovieData data) {
		return service.updateMovie(id, data);
	}
	
	@PostMapping("/createUser")
	public Object createUser(@RequestBody @Valid UserData data ) {
		
		return service.createUser(data);
	}
	
	@PostMapping("/createMovie")
	public Object createMovie(@RequestBody @Valid MovieData data ) {
		
		return service.createMovie(data);
	}
	
	@PostMapping("/createRating")
	public Object createRating(@RequestBody @Valid RatingsData data ) {
		
		return service.createRating(data);
	}

	@PostMapping("/createRental")
	public Object createRental( @RequestBody @Valid  RentalData data ) {
	
	return service.createRental(data);
}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	 
}
