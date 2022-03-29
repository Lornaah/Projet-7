package com.nnk.springboot.services.bid;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.model.BidList;

public interface BidListService {

	public List<BidList> findAllBids();

	public BidList updateBid(BidList bid);

	public Optional<BidList> findById(Integer id);

	public void deleteBid(BidList bidList);

}
