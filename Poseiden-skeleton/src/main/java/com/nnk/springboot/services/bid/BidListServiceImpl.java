package com.nnk.springboot.services.bid;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.BidListDTO;
import com.nnk.springboot.model.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListServiceImpl implements BidListService {

	@Autowired
	BidListRepository bidListRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<BidListDTO> findAllBids() {
		logger.info("findAllBids called");
		List<BidList> bidList = bidListRepository.findAll();
		List<BidListDTO> bidListDTO = bidList.stream().map(b -> new BidListDTO(b)).toList();
		return bidListDTO;
	}

	@Override
	@Transactional
	public BidListDTO updateBid(BidListDTO bid) {
		logger.info("updateBid called on the bid : " + bid.toString());
		BidList bidList = bidListRepository.getById(bid.getBidListId());
		bidList.update(bid);
		bidListRepository.save(bidList);
		return bid;
	}

	@Override
	public Optional<BidListDTO> findById(Integer id) {
		logger.info("findById called with Id : " + id);
		Optional<BidList> bid = bidListRepository.findById(id);
		return bid.map(b -> new BidListDTO(b));
	}

	@Override
	public void deleteBid(BidListDTO bidList) {
		logger.info("deleteBid called on " + bidList.toString());
		bidListRepository.deleteById(bidList.getBidListId());
	}

	@Override
	public BidListDTO createBid(BidListDTO bidListDTO) {
		BidList bid = new BidList();
		bid.update(bidListDTO);
		bidListRepository.save(bid);
		bidListDTO.setBidListId(bid.getBidListId());

		return bidListDTO;
	}

}
