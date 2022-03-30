package com.nnk.springboot.services.curve;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.CurvePointDTO;
import com.nnk.springboot.model.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements CurvePointService {

	@Autowired
	CurvePointRepository curvePointRepository;

	private static final Logger logger = LogManager.getLogger("BidListService");

	@Override
	public List<CurvePointDTO> findAllCurves() {
		logger.info("findAllCurves called");
		List<CurvePoint> curveList = curvePointRepository.findAll();
		List<CurvePointDTO> curvelistDTO = curveList.stream().map(c -> new CurvePointDTO(c)).toList();
		return curvelistDTO;
	}

	@Override
	public CurvePointDTO updateCurve(CurvePointDTO curvePoint) {
		logger.info("findAllCurves called");
		CurvePoint curve = curvePointRepository.getById(curvePoint.getId());
		curve.update(curvePoint);
		curvePointRepository.save(curve);
		return curvePoint;
	}

	@Override
	public Optional<CurvePointDTO> findById(Integer id) {
		logger.info("findAllCurves called with id : " + id);
		Optional<CurvePoint> curve = curvePointRepository.findById(id);
		return curve.map(c -> new CurvePointDTO(c));
	}

	@Override
	public void deleteCurve(CurvePointDTO curvePoint) {
		logger.info("deleteCurve called on " + curvePoint.toString());
		curvePointRepository.deleteById(curvePoint.getId());
	}

	@Override
	public CurvePointDTO createCurve(CurvePointDTO curvePointDTO) {
		CurvePoint curve = new CurvePoint();
		curve.update(curvePointDTO);
		curvePointRepository.save(curve);
		curvePointDTO.setId(curve.getId());
		return curvePointDTO;
	}

}
