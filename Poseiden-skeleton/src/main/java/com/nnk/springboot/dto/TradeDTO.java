package com.nnk.springboot.dto;

import java.util.Objects;

import com.nnk.springboot.model.Trade;

public class TradeDTO {

	private Integer tradeId;
	private String account;
	private String type;
	private Double buyQuantity;

	public TradeDTO() {
	}

	public TradeDTO(Trade trade) {
		this.tradeId = trade.getTradeId();
		this.account = trade.getAccount();
		this.type = trade.getType();
		this.buyQuantity = trade.getBuyQuantity();
	}

	public TradeDTO(String account, String type, Double buyQuantity) {
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
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

	public Double getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(Double buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	@Override
	public String toString() {
		return "TradeDTO [tradeId=" + tradeId + ", account=" + account + ", type=" + type + ", buyQuantity="
				+ buyQuantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, buyQuantity, tradeId, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeDTO other = (TradeDTO) obj;
		return Objects.equals(account, other.account) && Objects.equals(buyQuantity, other.buyQuantity)
				&& Objects.equals(tradeId, other.tradeId) && Objects.equals(type, other.type);
	}

}
