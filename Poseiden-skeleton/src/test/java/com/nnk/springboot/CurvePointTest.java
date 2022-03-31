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

import com.nnk.springboot.dto.CurvePointDTO;
import com.nnk.springboot.services.curve.CurvePointService;

@SpringBootTest
@Transactional
public class CurvePointTest {

	@Autowired
	private CurvePointService curvePointService;

	@Autowired
	private ClearDB clearDB;

	private CurvePointDTO curvePointDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		curvePointDTO = new CurvePointDTO(10, 10d, 30d);
	}

	@Test
	public void curvePointCreateTest() {
		// Arrange
		curvePointService.createCurve(curvePointDTO);

		// Act
		Optional<CurvePointDTO> curve = curvePointService.findById(curvePointDTO.getId());

		// Assert
		assertTrue(curve.isPresent());
		assertNotNull(curvePointDTO);
	}

	@Test
	public void curvePointUpdateTest() {
		// Arrange
		curvePointService.createCurve(curvePointDTO);
		curvePointDTO.setCurveId(20);

		// Act
		CurvePointDTO newCurve = curvePointService.updateCurve(curvePointDTO);

		// Assert
		assertTrue(newCurve.getCurveId() == 20);
	}

	@Test
	public void curvePointFindTest() {
		// Arrange
		curvePointService.createCurve(curvePointDTO);

		// Act
		List<CurvePointDTO> curveListDTO = curvePointService.findAllCurves();

		// Assert
		assertFalse(curveListDTO.isEmpty());
		assertTrue(curveListDTO.contains(curvePointDTO));

	}

	@Test
	public void curvePointDeleteTest() {
		// Arrange
		curvePointService.createCurve(curvePointDTO);

		// Act
		List<CurvePointDTO> oldCurveListDTO = curvePointService.findAllCurves();
		curvePointService.deleteCurve(curvePointDTO);
		List<CurvePointDTO> newCurveListDTO = curvePointService.findAllCurves();

		// Assert
		assertTrue(oldCurveListDTO.size() - 1 == newCurveListDTO.size());
		assertFalse(newCurveListDTO.contains(curvePointDTO));
	}
}
