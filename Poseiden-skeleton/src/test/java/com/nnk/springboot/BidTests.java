package com.nnk.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.dto.BidListDTO;
import com.nnk.springboot.services.bid.BidListService;

@SpringBootTest
@Transactional
public class BidTests {

	@Autowired
	private BidListService bidListService;

	@Autowired
	ClearDB clearDB;

	private BidListDTO bidListDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		bidListDTO = new BidListDTO("AccountTest", "TypeTest", 10);
	}

	@Test
	public void bidListCreateTest() {
		// Arrange
		bidListService.createBid(bidListDTO);

		// Act
		Optional<BidListDTO> bid = bidListService.findById(bidListDTO.getBidListId());

		// Assert
		assertTrue(bid.isPresent());
		assertNotNull(bidListDTO);
	}

	@Test
	public void bidListUpdateTest() {
		// Arrange
		bidListService.createBid(bidListDTO);
		bidListDTO.setBidQuantity(20);

		// Act
		BidListDTO newBidList = bidListService.updateBid(bidListDTO);

		// Assert
		assertTrue(newBidList.getBidQuantity() == 20);
	}

	@Test
	public void bidListFindTest() {
		// Arrange
		bidListService.createBid(bidListDTO);

		// Act
		List<BidListDTO> bidDTO = bidListService.findAllBids();

		// Assert
		assertFalse(bidDTO.isEmpty());
		assertTrue(bidDTO.contains(bidListDTO));

	}

	@Test
	public void bidListDeleteTest() {
		// Arrange
		bidListService.createBid(bidListDTO);

		// Act
		List<BidListDTO> oldCurveListDTO = bidListService.findAllBids();
		bidListService.deleteBid(bidListDTO);
		List<BidListDTO> newCurveListDTO = bidListService.findAllBids();

		// Assert
		assertTrue(oldCurveListDTO.size() - 1 == newCurveListDTO.size());
		assertFalse(newCurveListDTO.contains(bidListDTO));
	}
}
