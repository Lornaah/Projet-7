package com.nnk.springboot.services.bid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListServiceImpl implements BidListService {

	@Autowired
	BidListRepository bidListRepository;

	@Override
	public List<BidList> findAllBids() {
		return bidListRepository.findAll();
	}

	@Override
	public BidList updateBid(BidList bid) {
		return bidListRepository.save(bid);
	}

	@Override
	public Optional<BidList> findById(Integer id) {
		return bidListRepository.findById(id);
	}

	@Override
	public void deleteBid(BidList bidList) {
		bidListRepository.deleteById(bidList.getBidListId());
	}

}
