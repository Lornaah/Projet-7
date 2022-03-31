package com.nnk.springboot.dto;

import java.util.Objects;

import com.nnk.springboot.model.Rating;

public class RatingDTO {

	private Integer id;
	private String moodysRating;
	private String sandPRating;
	private String fitchRating;
	private Integer orderNumber;

	public RatingDTO() {
	}

	public RatingDTO(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

	public RatingDTO(Rating rating) {
		this.id = rating.getId();
		this.moodysRating = rating.getMoodysRating();
		this.sandPRating = rating.getSandPRating();
		this.fitchRating = rating.getFitchRating();
		this.orderNumber = rating.getOrderNumber();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoodysRating() {
		return moodysRating;
	}

	public void setMoodysRating(String moodysRating) {
		this.moodysRating = moodysRating;
	}

	public String getSandPRating() {
		return sandPRating;
	}

	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}

	public String getFitchRating() {
		return fitchRating;
	}

	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "RatingDTO [id=" + id + ", moodysRating=" + moodysRating + ", sandPRating=" + sandPRating
				+ ", fitchRating=" + fitchRating + ", orderNumber=" + orderNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fitchRating, id, moodysRating, orderNumber, sandPRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingDTO other = (RatingDTO) obj;
		return Objects.equals(fitchRating, other.fitchRating) && Objects.equals(id, other.id)
				&& Objects.equals(moodysRating, other.moodysRating) && Objects.equals(orderNumber, other.orderNumber)
				&& Objects.equals(sandPRating, other.sandPRating);
	}

}
