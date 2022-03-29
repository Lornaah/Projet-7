package com.nnk.springboot.services.bid;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListServiceImpl implements BidListService {

	@Autowired
	BidListRepository bidListRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<BidList> findAllBids() {
		logger.info("findAllBids called");
		return bidListRepository.findAll();
	}

	@Override
	public BidList updateBid(BidList bid) {
		logger.info("updateBid called on the bid : " + bid.toString());
		return bidListRepository.save(bid);
	}

	@Override
	public Optional<BidList> findById(Integer id) {
		logger.info("findById called with Id : " + id);
		return bidListRepository.findById(id);
	}

	@Override
	public void deleteBid(BidList bidList) {
		logger.info("deleteBid called on " + bidList.toString());
		bidListRepository.deleteById(bidList.getBidListId());
	}

}
