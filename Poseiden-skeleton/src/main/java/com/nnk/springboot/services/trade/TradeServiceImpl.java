package com.nnk.springboot.services.trade;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<Trade> findAllTrades() {
		logger.info("findAllTrades called");
		return tradeRepository.findAll();
	}

	@Override
	public Trade updateTrade(Trade trade) {
		logger.info("updateTrade called on " + trade.toString());
		return tradeRepository.save(trade);
	}

	@Override
	public Optional<Trade> findById(Integer id) {
		logger.info("findById called with id : " + id);
		return tradeRepository.findById(id);
	}

	@Override
	public void deleteTrade(Trade trade) {
		logger.info("deleteTrade called on " + trade.toString());
		tradeRepository.delete(trade);
	}

}
