package com.nnk.springboot.services.trade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	@Override
	public List<Trade> findAllTrades() {
		return tradeRepository.findAll();
	}

	@Override
	public Trade updateTrade(Trade trade) {
		return tradeRepository.save(trade);
	}

	@Override
	public Optional<Trade> findById(Integer id) {
		return tradeRepository.findById(id);
	}

	@Override
	public void deleteTrade(Trade trade) {
		tradeRepository.delete(trade);
	}

}
