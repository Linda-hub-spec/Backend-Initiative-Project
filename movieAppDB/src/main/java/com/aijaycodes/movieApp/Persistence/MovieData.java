package com.aijaycodes.movieApp.Persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="movie")
public class MovieData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="movieId")
	Long id;
	
	@Column(name ="title")
	String title;
	
	@Column(name ="year")
	String year;
	
	@Column(name ="	country")
	String country;
	
	@Column(name ="producer")
	String producer;
	
	@Column(name ="genre")
	String genre;
	
	@Column(name ="length")
	String length;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * public String getRatings() { return ratings; }
	 * 
	 * public void setRatings(String ratings) { this.ratings = ratings; }
	 */

	/*
	 * public String getYear() { return year; }
	 * 
	 * public void setYear(String year) { this.year = year; }
	 */
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
}
