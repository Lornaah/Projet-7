package com.nnk.springboot.services.trade;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.model.Trade;

public interface TradeService {

	public List<Trade> findAllTrades();

	public Trade updateTrade(Trade trade);

	public Optional<Trade> findById(Integer id);

	public void deleteTrade(Trade trade);
}
