package com.nnk.springboot.services.trade;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.dto.TradeDTO;

public interface TradeService {

	public List<TradeDTO> findAllTrades();

	public TradeDTO updateTrade(TradeDTO trade);

	public Optional<TradeDTO> findById(Integer id);

	public void deleteTrade(TradeDTO trade);

	public TradeDTO createTrade(TradeDTO trade);
}
