package com.nnk.springboot.dto;

import com.nnk.springboot.model.CurvePoint;

public class CurvePointDTO {

	private Integer id;
	private Integer curveId;
	private Double term;
	private Double value;

	public CurvePointDTO(CurvePoint curve) {
		this.id = curve.getId();
		this.curveId = curve.getCurveId();
		this.term = curve.getTerm();
		this.value = curve.getValue();
	}

	public CurvePointDTO(Integer curveId, Double term, Double value) {
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}

	public CurvePointDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurveId() {
		return curveId;
	}

	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}

	public Double getTerm() {
		return term;
	}

	public void setTerm(Double term) {
		this.term = term;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
