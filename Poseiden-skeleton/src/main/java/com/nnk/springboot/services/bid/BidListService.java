package com.nnk.springboot.services.bid;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.dto.BidListDTO;

public interface BidListService {

	public List<BidListDTO> findAllBids();

	public BidListDTO updateBid(BidListDTO bid);

	public Optional<BidListDTO> findById(Integer id);

	public void deleteBid(BidListDTO bidList);

	public BidListDTO createBid(BidListDTO bidListDTO);

}
