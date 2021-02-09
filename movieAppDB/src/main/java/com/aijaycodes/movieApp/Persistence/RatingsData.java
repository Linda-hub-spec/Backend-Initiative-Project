package com.aijaycodes.movieApp.Persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ratings")
public class RatingsData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ratingId")
	Long ratingsId;
	
	@Column
	Long movieId;
	
	@Column
	Long userId;
	
	@Column
	@Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 5, message = "Rating should not be greater than 5")
	String rating;

	public Long getRatingsId() {
		return ratingsId;
	}

	public void setRatingsId(Long ratingsId) {
		this.ratingsId = ratingsId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
