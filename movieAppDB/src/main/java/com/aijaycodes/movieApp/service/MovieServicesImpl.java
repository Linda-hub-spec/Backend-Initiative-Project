package com.aijaycodes.movieApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aijaycodes.movieApp.Persistence.MovieData;
import com.aijaycodes.movieApp.Persistence.MovieRepository;
import com.aijaycodes.movieApp.Persistence.RatingRepository;
import com.aijaycodes.movieApp.Persistence.RatingsData;
import com.aijaycodes.movieApp.Persistence.RentalData;
import com.aijaycodes.movieApp.Persistence.RentalRepository;
import com.aijaycodes.movieApp.Persistence.Response;
import com.aijaycodes.movieApp.Persistence.UserData;
import com.aijaycodes.movieApp.Persistence.UserRepository;



@Service
public class MovieServicesImpl implements MovieService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	RentalRepository rentalRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	
	
	Response response = new Response();
	
	public Object createMovie(MovieData data) {
		
		
		movieRepository.save(data);
		
		response.setStatus("00");
		response.setMessage("Movie Added");
		return response;
	}
	
	public Object createUser(UserData data) {
		
		userRepository.save(data);
		response.setStatus("00");
		response.setMessage("User created");
		return response;
	}
	
	public Object createRating(RatingsData data) {
		
		ratingRepository.save(data);
		response.setStatus("00");
		response.setMessage("Rating Added");
		return response;
	}
	
	public Object createRental(RentalData data) {
		
		rentalRepository.save(data);
		response.setStatus("00");
		response.setMessage("Rental Added");
		return response;
	}
	
	public Object updateMovie(String id, MovieData data) {
		List<MovieData> movies =  getMovies() ;
		Long userId = Long.parseLong(id);
		MovieData newData = new MovieData();
		
		for(int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getId() == userId) {
				
				
				if(data.getCountry() == null || data.getCountry() == ""){
					System.out.println("country not modified");
				}else {
					movies.get(i).setCountry(data.getCountry());
				}
				if(data.getTitle()== null || data.getTitle()== ""){
					System.out.println("title not modified");
				}else {
					movies.get(i).setTitle(data.getTitle());
				}
				if(data.getYear() == null || data.getYear() == "") {
					System.out.println("year not modified");
				}else{
					movies.get(i).setYear(data.getYear());
				}
				if(data.getGenre() == null || data.getGenre() == "") {
					System.out.println("genre not modified");
				}else{
					movies.get(i).setGenre(data.getGenre());
				}
				if(data.getLength() == null || data.getLength() == "") {
					System.out.println("length not modified");
				}else{
					movies.get(i).setLength(data.getLength());
				}
				
			}
			newData = movies.get(i);
		}
		movieRepository.save(newData);	
		response.setStatus("00");
		response.setMessage("Movie updated");
		return response;
	}
	
	public Object updateRatings(String id, RatingsData data) {
	
		List<RatingsData> ratings =  getRatings() ;
		Long userId = Long.parseLong(id);
		RatingsData newData = new RatingsData();
		
		for(int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getRatingsId() == userId) {
				
				
				if(data.getMovieId() == null ){
					System.out.println("movie not modified");
				} else{
					ratings.get(i).setMovieId(data.getMovieId());
				}
				if(data.getRating()== null || data.getRating()== ""){
					System.out.println("rating not modified");
				}else {
					ratings.get(i).setRating(data.getRating());
				}
				if(data.getUserId() == null) {
					System.out.println("user not modified");
				}else{
					ratings.get(i).setUserId(data.getUserId());
				}
				
			}
			newData= ratings.get(i);
		}
		
		ratingRepository.save(newData);
		response.setStatus("00");
		response.setMessage("Rating updated");
		return response;
	}
	
	public Object updateRentals(String id, RentalData data) {
		
		List<RentalData> rentals =  getRentals() ;
		Long userId = Long.parseLong(id);
		RentalData newData = new RentalData();
		
		for(int i = 0; i < rentals.size(); i++) {
			if (rentals.get(i).getRentalId() == userId) {
				
				
				if(data.getMovieId() == null ) {
					System.out.println("movie not modified");
				}else{
					rentals.get(i).setMovieId(data.getMovieId());
				}
				if(data.getDate() == null || data.getDate() == "") {
					System.out.println("date not modified");
				}else{
					rentals.get(i).setDate(data.getDate());
				}
				if(data.getUserId() == null ){
					System.out.println("user not modified");
				}else {
					rentals.get(i).setUserId(data.getUserId());
				}
				
			}
			newData = rentals.get(i);
		}
		
		rentalRepository.save(newData);
		response.setStatus("00");
		response.setMessage("Rental updated");
		return response;
	}
	
	public Object updateUser(String id,UserData data) {
		
		List<UserData> users =  getUsers() ;
		Long userId = Long.parseLong(id);
		UserData newData = new UserData();
		
		for(int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId() == userId) {
				
				
				if(data.getName() == null || data.getName() == "") {
					System.out.println("name not modified");
				}else{
					users.get(i).setName(data.getName());
				}
				if(data.getEmail() == null || data.getEmail() == "") {
					System.out.println("date not modified");
				}else{
					users.get(i).setEmail(data.getEmail());
				}
				if(data.getPassword() == null || data.getPassword() == "" ){
					System.out.println("user not modified");
				}else {
					users.get(i).setPassword(data.getPassword());
				}
				if(data.getUsername() == null || data.getUsername() == "" ){
					System.out.println("user not modified");
				}else {
					users.get(i).setUsername(data.getUsername());
				}
				
			}
			newData = users.get(i);
		}
		
		userRepository.save(newData);
		response.setStatus("00");
		response.setMessage("User updated");
		return response;
	}
	
	public Object deleteMovie(String id) {
		
		Long userId = Long.parseLong(id);
		movieRepository.deleteById(userId);
		response.setStatus("00");
		response.setMessage("Movie Deleted");
		return response;
	}
	
	public Object deleteUser(String id) {
		
		Long userId = Long.parseLong(id);
		userRepository.deleteById(userId);
		response.setStatus("00");
		response.setMessage("User Deleted");
		return response;
	}
	
	public Object deleteRating(String id) {
		
		Long userId = Long.parseLong(id);
		ratingRepository.deleteById(userId);
		
		response.setStatus("00");
		response.setMessage("Rating Deleted");
		return response;
	}
	public Object deleteRentals(String id) {
		
		Long userId = Long.parseLong(id);
		rentalRepository.deleteById(userId);
		response.setStatus("00");
		response.setMessage("Rental Deleted");
		return response;
	}
	
	public List<UserData> getUsers() {
		List<UserData> users = new ArrayList<UserData>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	public List<RentalData> getRentals() {
		
		List<RentalData> rentals = new ArrayList<RentalData>();
		rentalRepository.findAll().forEach(rent -> rentals.add(rent));
		return rentals;
	}

	
	public List<RatingsData> getRatings() {
		
		List<RatingsData> ratings = new ArrayList<RatingsData>();
		ratingRepository.findAll().forEach(rating -> ratings.add(rating));
		
		return ratings;
	}
	
	public List<MovieData> getMovies() {
		
		List<MovieData> movies = new ArrayList<MovieData>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}

}
