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

import com.nnk.springboot.dto.TradeDTO;
import com.nnk.springboot.services.trade.TradeService;

@SpringBootTest
@Transactional
public class TradeTests {

	@Autowired
	private TradeService tradeService;

	@Autowired
	private ClearDB clearDB;

	private TradeDTO tradeDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		tradeDTO = new TradeDTO("Test", "Test", 10.00);
	}

	@Test
	public void tradeCreateTest() {
		// Arrange
		tradeService.createTrade(tradeDTO);

		// Act
		Optional<TradeDTO> trade = tradeService.findById(tradeDTO.getTradeId());

		// Assert
		assertTrue(trade.isPresent());
		assertNotNull(tradeDTO);
	}

	@Test
	public void tradeUpdateTest() {
		// Arrange
		tradeService.createTrade(tradeDTO);
		tradeDTO.setAccount("TestTest");

		// Act
		TradeDTO newTrade = tradeService.updateTrade(tradeDTO);

		// Assert
		assertTrue(newTrade.getAccount().equals("TestTest"));
	}

	@Test
	public void tradeGetTest() {
		// Arrange
		tradeService.createTrade(tradeDTO);

		// Act
		List<TradeDTO> tradeList = tradeService.findAllTrades();

		// Assert
		assertFalse(tradeList.isEmpty());
		assertTrue(tradeList.contains(tradeDTO));
	}

	@Test
	public void tradeDeleteTest() {
		// Arrange
		tradeService.createTrade(tradeDTO);

		// Act
		List<TradeDTO> oldList = tradeService.findAllTrades();
		tradeService.deleteTrade(tradeDTO);
		List<TradeDTO> newList = tradeService.findAllTrades();

		// Assert
		assertTrue(oldList.size() - 1 == newList.size());
		assertFalse(newList.contains(tradeDTO));
	}
}
