package com.nnk.springboot.services.rating;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.RatingDTO;
import com.nnk.springboot.model.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingSeviceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	private static final Logger logger = LogManager.getLogger("RatingService");

	@Override
	public List<RatingDTO> findAllRatings() {
		logger.info("findallRatings called");
		List<Rating> ratingList = ratingRepository.findAll();
		List<RatingDTO> ratingListDTO = ratingList.stream().map(r -> new RatingDTO(r)).toList();
		return ratingListDTO;
	}

	@Override
	@Transactional
	public RatingDTO updateRating(RatingDTO ratingDTO) {
		logger.info("updateRating called on " + ratingDTO.toString());
		Rating rating = ratingRepository.getById(ratingDTO.getId());
		rating.update(ratingDTO);
		ratingRepository.save(rating);
		return ratingDTO;
	}

	@Override
	public Optional<RatingDTO> findById(Integer id) {
		logger.info("findById called with id : " + id);
		Optional<Rating> rating = ratingRepository.findById(id);
		return rating.map(r -> new RatingDTO(r));
	}

	@Override
	public void deleteRating(RatingDTO rating) {
		logger.info("deleteRating called on " + rating.toString());
		ratingRepository.deleteById(rating.getId());

	}

	@Override
	public RatingDTO createRating(RatingDTO ratingDTO) {
		Rating rating = new Rating();
		rating.update(ratingDTO);
		ratingRepository.save(rating);
		ratingDTO.setId(rating.getId());
		return ratingDTO;
	}
}
