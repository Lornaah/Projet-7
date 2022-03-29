package com.nnk.springboot.services.rating;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.model.Rating;

public interface RatingService {

	public List<Rating> findAllRatings();

	public Rating updateRating(Rating rating);

	public Optional<Rating> findById(Integer id);

	public void deleteRating(Rating rating);

}
