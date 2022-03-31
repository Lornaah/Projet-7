package com.nnk.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.dto.RuleNameDTO;
import com.nnk.springboot.services.ruleName.RuleNameService;

@SpringBootTest
@Transactional
public class RuleTests {

	@Autowired
	private RuleNameService ruleNameService;

	@Autowired
	private ClearDB clearDB;

	private RuleNameDTO ruleNameDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		ruleNameDTO = new RuleNameDTO("Test", "Test", "Test", "Test", "Test", "Test");
	}

	@Test
	public void ruleCreateTest() {
		// Arrange
		ruleNameService.createRule(ruleNameDTO);

		// Act
		Optional<RuleNameDTO> rule = ruleNameService.findById(ruleNameDTO.getId());

		// Assert
		assertTrue(rule.isPresent());
		assertNotNull(ruleNameDTO);

	}

	@Test
	public void ruleUpdateTest() {
		// Arrange
		ruleNameService.createRule(ruleNameDTO);
		ruleNameDTO.setDescription("TestTest");

		// Act
		RuleNameDTO newRule = ruleNameService.updateRuleName(ruleNameDTO);

		// Assert
		assertTrue(newRule.getDescription().equals("TestTest"));
	}

	@Test
	public void ruleFindTest() {
		// Arrange
		ruleNameService.createRule(ruleNameDTO);

		// Act
		List<RuleNameDTO> ruleListDTO = ruleNameService.findAllRuleNames();

		// Assert
		assertFalse(ruleListDTO.isEmpty());
		assertTrue(ruleListDTO.contains(ruleNameDTO));

	}

	@Test
	public void ruleDeleteTest() {
		// Arrange
		ruleNameService.createRule(ruleNameDTO);

		// Act
		List<RuleNameDTO> oldRuleListDTO = ruleNameService.findAllRuleNames();
		ruleNameService.deleteRuleName(ruleNameDTO);
		List<RuleNameDTO> newRuleListDTO = ruleNameService.findAllRuleNames();

		// Assert
		assertTrue(oldRuleListDTO.size() - 1 == newRuleListDTO.size());
		assertFalse(newRuleListDTO.contains(ruleNameDTO));
	}
}
