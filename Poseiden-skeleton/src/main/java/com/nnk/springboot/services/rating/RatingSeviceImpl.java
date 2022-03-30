package com.nnk.springboot.services.rating;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingSeviceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<Rating> findAllRatings() {
		logger.info("findallRatings called");
		return ratingRepository.findAll();
	}

	@Override
	public Rating updateRating(Rating rating) {
		logger.info("updateRating called on " + rating.toString());
		return ratingRepository.save(rating);
	}

	@Override
	public Optional<Rating> findById(Integer id) {
		logger.info("findById called with id : " + id);
		return ratingRepository.findById(id);
	}

	@Override
	public void deleteRating(Rating rating) {
		logger.info("deleteRating called on " + rating.toString());
		ratingRepository.delete(rating);

	}
}
