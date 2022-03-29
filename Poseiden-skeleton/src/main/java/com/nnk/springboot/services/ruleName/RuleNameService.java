package com.nnk.springboot.services.ruleName;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.model.RuleName;

public interface RuleNameService {

	public List<RuleName> findAllRuleNames();

	public RuleName updateRuleName(RuleName ruleName);

	public Optional<RuleName> findById(Integer id);

	public void deleteRuleName(RuleName ruleName);
}
