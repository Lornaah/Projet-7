package com.nnk.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class ClearDB {

	@Autowired
	BidListRepository bidListRepository;
	@Autowired
	CurvePointRepository curvePointRepository;
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	RuleNameRepository ruleNameRepository;
	@Autowired
	TradeRepository tradeRepository;
	@Autowired
	UserRepository userRepository;

	public void clearDB() {
		bidListRepository.deleteAll();
		curvePointRepository.deleteAll();
		ratingRepository.deleteAll();
		ruleNameRepository.deleteAll();
		tradeRepository.deleteAll();
		userRepository.deleteAll();
	}

}
