package com.nnk.springboot.services.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingSeviceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public List<Rating> findAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Rating updateRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public Optional<Rating> findById(Integer id) {
		// TODO Auto-generated method stub
		return ratingRepository.findById(id);
	}

	@Override
	public void deleteRating(Rating rating) {
		// TODO Auto-generated method stub
		ratingRepository.delete(rating);

	}
}
