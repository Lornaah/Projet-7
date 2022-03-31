package com.nnk.springboot.dto;

import java.util.Objects;

import com.nnk.springboot.model.BidList;

public class BidListDTO {

	private int bidListId;
	private String account;
	private String type;
	private double bidQuantity;

	public BidListDTO() {
	}

	public BidListDTO(BidList bid) {
		this.bidListId = bid.getBidListId();
		this.account = bid.getAccount();
		this.type = bid.getType();
		this.bidQuantity = bid.getBidQuantity();
	}

	public BidListDTO(String account, String type, double bidQuantity) {
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

	public int getBidListId() {
		return bidListId;
	}

	public void setBidListId(int bidListId) {
		this.bidListId = bidListId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBidQuantity() {
		return bidQuantity;
	}

	public void setBidQuantity(double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	@Override
	public String toString() {
		return "BidListDTO [bidListId=" + bidListId + ", account=" + account + ", type=" + type + ", bidQuantity="
				+ bidQuantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, bidListId, bidQuantity, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidListDTO other = (BidListDTO) obj;
		return Objects.equals(account, other.account) && bidListId == other.bidListId
				&& Double.doubleToLongBits(bidQuantity) == Double.doubleToLongBits(other.bidQuantity)
				&& Objects.equals(type, other.type);
	}

}
