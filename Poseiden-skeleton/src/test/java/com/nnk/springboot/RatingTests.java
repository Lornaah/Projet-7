package com.nnk.springboot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.dto.RatingDTO;
import com.nnk.springboot.services.rating.RatingService;

@SpringBootTest
public class RatingTests {

	@Autowired
	private RatingService ratingService;

	@Autowired
	private ClearDB clearDB;

	private RatingDTO ratingDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		ratingDTO = new RatingDTO("Test", "Test", "Test", 10);
	}

	@Test
	public void ratingCreateTest() {
		// Arrange
		ratingService.createRating(ratingDTO);

		// Act
		Optional<RatingDTO> rating = ratingService.findById(ratingDTO.getId());

		// Assert
		assertTrue(rating.isPresent());
		assertNotNull(ratingDTO);
	}

	@Test
	public void ratingUpdateTest() {
		// Arrange
		ratingService.createRating(ratingDTO);
		ratingDTO.setOrderNumber(20);

		// Act
		RatingDTO newRating = ratingService.updateRating(ratingDTO);

		// Assert
		assertTrue(newRating.getOrderNumber() == 20);
	}

	@Test
	public void ratingFindTest() {
		// Arrange
		ratingService.createRating(ratingDTO);

		// Act
		List<RatingDTO> ratingDTOList = ratingService.findAllRatings();

		// Assert
		assertFalse(ratingDTOList.isEmpty());
		assertTrue(ratingDTOList.contains(ratingDTO));
	}

	@Test
	public void ratingDeleteTest() {
		// Arrange
		ratingService.createRating(ratingDTO);

		// Act
		List<RatingDTO> oldRatingList = ratingService.findAllRatings();
		ratingService.deleteRating(ratingDTO);
		List<RatingDTO> newRatingList = ratingService.findAllRatings();

		// Assert
		assertTrue(oldRatingList.size() - 1 == newRatingList.size());
		assertFalse(newRatingList.contains(ratingDTO));
	}
}
