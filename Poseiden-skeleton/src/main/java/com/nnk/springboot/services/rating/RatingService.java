package com.nnk.springboot.services.rating;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.dto.RatingDTO;

public interface RatingService {

	public List<RatingDTO> findAllRatings();

	public RatingDTO updateRating(RatingDTO rating);

	public Optional<RatingDTO> findById(Integer id);

	public void deleteRating(RatingDTO rating);

	public RatingDTO createRating(RatingDTO ratingDTO);

}
