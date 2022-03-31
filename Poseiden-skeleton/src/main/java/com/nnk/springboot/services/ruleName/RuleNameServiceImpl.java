package com.nnk.springboot.services.ruleName;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.RuleNameDTO;
import com.nnk.springboot.model.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements RuleNameService {

	@Autowired
	RuleNameRepository ruleNameRepository;

	private static final Logger logger = LogManager.getLogger("RuleNameService");

	@Override
	public List<RuleNameDTO> findAllRuleNames() {
		logger.info("findAllRuleNames called");
		List<RuleName> ruleList = ruleNameRepository.findAll();
		List<RuleNameDTO> ruleListDTO = ruleList.stream().map(r -> new RuleNameDTO(r)).toList();
		return ruleListDTO;
	}

	@Override
	public RuleNameDTO updateRuleName(RuleNameDTO ruleNameDTO) {
		logger.info("updateRuleName called on " + ruleNameDTO.toString());
		RuleName ruleName = ruleNameRepository.getById(ruleNameDTO.getId());
		ruleName.update(ruleNameDTO);
		ruleNameRepository.save(ruleName);
		return ruleNameDTO;
	}

	@Override
	public Optional<RuleNameDTO> findById(int id) {
		logger.info("findById called with id : " + id);
		Optional<RuleName> rule = ruleNameRepository.findById(id);
		return rule.map(r -> new RuleNameDTO(r));
	}

	@Override
	public void deleteRuleName(RuleNameDTO ruleName) {
		logger.info("deleteRuleName called on " + ruleName.toString());
		ruleNameRepository.deleteById(ruleName.getId());
	}

	@Override
	public RuleNameDTO createRule(RuleNameDTO rule) {
		System.out.println(rule);
		RuleName ruleName = new RuleName();
		ruleName.update(rule);
		ruleNameRepository.save(ruleName);
		rule.setId(ruleName.getId());
		return rule;
	}
}
