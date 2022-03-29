package com.nnk.springboot.services.curve;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements CurvePointService {

	@Autowired
	CurvePointRepository curvePointRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<CurvePoint> findAllCurves() {
		logger.info("findAllCurves called");
		return curvePointRepository.findAll();
	}

	@Override
	public CurvePoint updateCurve(CurvePoint curvePoint) {
		logger.info("findAllCurves called");
		return curvePointRepository.save(curvePoint);
	}

	@Override
	public Optional<CurvePoint> findById(Integer id) {
		logger.info("findAllCurves called with id : " + id);
		return curvePointRepository.findById(id);
	}

	@Override
	public void deleteCurve(CurvePoint curvePoint) {
		logger.info("deleteCurve called on " + curvePoint.toString());
		curvePointRepository.delete(curvePoint);
	}

}
