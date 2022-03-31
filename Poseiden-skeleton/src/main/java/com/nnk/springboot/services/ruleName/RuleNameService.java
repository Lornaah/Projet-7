package com.nnk.springboot.services.ruleName;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.dto.RuleNameDTO;

public interface RuleNameService {

	public List<RuleNameDTO> findAllRuleNames();

	public RuleNameDTO updateRuleName(RuleNameDTO ruleName);

	public Optional<RuleNameDTO> findById(int id);

	public void deleteRuleName(RuleNameDTO ruleName);

	public RuleNameDTO createRule(RuleNameDTO rule);
}
