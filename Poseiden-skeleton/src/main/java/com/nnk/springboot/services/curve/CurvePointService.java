package com.nnk.springboot.services.curve;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.model.CurvePoint;

public interface CurvePointService {

	public List<CurvePoint> findAllCurves();

	public CurvePoint updateCurve(CurvePoint curvePoint);

	public Optional<CurvePoint> findById(Integer id);

	public void deleteCurve(CurvePoint curvePoint);

}
