package com.nnk.springboot.services.ruleName;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements RuleNameService {

	@Autowired
	RuleNameRepository ruleNameRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<RuleName> findAllRuleNames() {
		logger.info("findAllRuleNames called");
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName updateRuleName(RuleName ruleName) {
		logger.info("updateRuleName called on " + ruleName.toString());
		return ruleNameRepository.save(ruleName);
	}

	@Override
	public Optional<RuleName> findById(Integer id) {
		logger.info("findById called with id : " + id);
		return ruleNameRepository.findById(id);
	}

	@Override
	public void deleteRuleName(RuleName ruleName) {
		logger.info("deleteRuleName called on " + ruleName.toString());
		ruleNameRepository.delete(ruleName);
	}
}
