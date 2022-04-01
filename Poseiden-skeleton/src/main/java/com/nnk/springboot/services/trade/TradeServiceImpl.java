package com.nnk.springboot.services.trade;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.TradeDTO;
import com.nnk.springboot.model.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	private static final Logger logger = LogManager.getLogger("TradeService");

	@Override
	public List<TradeDTO> findAllTrades() {
		logger.info("findAllTrades called");
		List<Trade> tradeList = tradeRepository.findAll();
		List<TradeDTO> tradeListDTO = tradeList.stream().map(t -> new TradeDTO(t)).toList();
		return tradeListDTO;
	}

	@Override
	@Transactional
	public TradeDTO updateTrade(TradeDTO tradeDTO) {
		logger.info("updateTrade called on " + tradeDTO.toString());
		Trade trade = tradeRepository.getById(tradeDTO.getTradeId());
		trade.update(tradeDTO);
		tradeRepository.save(trade);
		return tradeDTO;
	}

	@Override
	public Optional<TradeDTO> findById(Integer id) {
		logger.info("findById called with id : " + id);
		Optional<Trade> trade = tradeRepository.findById(id);
		return trade.map(t -> new TradeDTO(t));
	}

	@Override
	public void deleteTrade(TradeDTO trade) {
		logger.info("deleteTrade called on " + trade.toString());
		tradeRepository.deleteById(trade.getTradeId());
	}

	@Override
	public TradeDTO createTrade(TradeDTO tradeDTO) {
		logger.info("createTrade called with " + tradeDTO.toString());
		Trade trade = new Trade();
		trade.update(tradeDTO);
		tradeRepository.save(trade);
		tradeDTO.setTradeId(trade.getTradeId());
		return tradeDTO;
	}

}
