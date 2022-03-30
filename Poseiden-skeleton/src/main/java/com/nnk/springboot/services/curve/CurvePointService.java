package com.nnk.springboot.services.curve;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.dto.CurvePointDTO;

public interface CurvePointService {

	public List<CurvePointDTO> findAllCurves();

	public CurvePointDTO updateCurve(CurvePointDTO curvePointDTO);

	public Optional<CurvePointDTO> findById(Integer id);

	public void deleteCurve(CurvePointDTO curvePoint);

	public CurvePointDTO createCurve(CurvePointDTO curvePointDTO);

}
