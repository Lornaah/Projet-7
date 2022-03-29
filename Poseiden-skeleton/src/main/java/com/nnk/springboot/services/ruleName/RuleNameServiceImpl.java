package com.nnk.springboot.services.ruleName;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements RuleNameService {

	@Autowired
	RuleNameRepository ruleNameRepository;

	@Override
	public List<RuleName> findAllRuleNames() {
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName updateRuleName(RuleName ruleName) {
		return ruleNameRepository.save(ruleName);
	}

	@Override
	public Optional<RuleName> findById(Integer id) {
		return ruleNameRepository.findById(id);
	}

	@Override
	public void deleteRuleName(RuleName ruleName) {
		ruleNameRepository.delete(ruleName);
	}
}
