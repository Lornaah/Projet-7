package com.nnk.springboot.services.curve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.model.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements CurvePointService {

	@Autowired
	CurvePointRepository curvePointRepository;

	@Override
	public List<CurvePoint> findAllCurves() {
		return curvePointRepository.findAll();
	}

	@Override
	public CurvePoint updateCurve(CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}

	@Override
	public Optional<CurvePoint> findById(Integer id) {
		return curvePointRepository.findById(id);
	}

	@Override
	public void deleteCurve(CurvePoint curvePoint) {
		curvePointRepository.delete(curvePoint);
	}

}
