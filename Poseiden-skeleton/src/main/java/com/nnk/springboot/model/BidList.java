package com.nnk.springboot.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nnk.springboot.dto.BidListDTO;

@Entity
@Table(name = "bidlist")
public class BidList {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bidListId;
	@NotNull
	private String account;
	@NotNull
	private String type;
	private double bidQuantity;
	private double askQuantity;
	private double bid;
	private double ask;
	private String benchmark;
	private Timestamp bidListDate;
	private String commentary;
	private String security;
	private String status;
	private String trader;
	private String book;
	private String creationName;
	private Timestamp creationDate;
	private String revisionName;
	private Timestamp revisionDate;
	private String dealName;
	private String dealType;
	private String sourceListId;
	private String side;

	public void update(BidListDTO bid) {
		this.account = bid.getAccount();
		this.type = bid.getType();
		this.bidQuantity = bid.getBidQuantity();
	}

	public BidList() {
	}

	public void setBidListDate(Timestamp bidListDate) {
		this.bidListDate = bidListDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public void setRevisionDate(Timestamp revisionDate) {
		this.revisionDate = revisionDate;
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

	public double getAskQuantity() {
		return askQuantity;
	}

	public void setAskQuantity(double askQuantity) {
		this.askQuantity = askQuantity;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public Date getBidListDate() {
		return bidListDate;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getCreationName() {
		return creationName;
	}

	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getRevisionName() {
		return revisionName;
	}

	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getSourceListId() {
		return sourceListId;
	}

	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "BidListDTO [bidListId=" + bidListId + ", account=" + account + ", type=" + type + ", bidQuantity="
				+ bidQuantity + ", askQuantity=" + askQuantity + ", bid=" + bid + ", ask=" + ask + ", benchmark="
				+ benchmark + ", bidListDate=" + bidListDate + ", commentary=" + commentary + ", security=" + security
				+ ", status=" + status + ", trader=" + trader + ", book=" + book + ", creationName=" + creationName
				+ ", creationDate=" + creationDate + ", revisionName=" + revisionName + ", revisionDate=" + revisionDate
				+ ", dealName=" + dealName + ", dealType=" + dealType + ", sourceListId=" + sourceListId + ", side="
				+ side + ", getBidListId()=" + getBidListId() + ", getAccount()=" + getAccount() + ", getType()="
				+ getType() + ", getBidQuantity()=" + getBidQuantity() + ", getAskQuantity()=" + getAskQuantity()
				+ ", getBid()=" + getBid() + ", getAsk()=" + getAsk() + ", getBenchmark()=" + getBenchmark()
				+ ", getBidListDate()=" + getBidListDate() + ", getCommentary()=" + getCommentary() + ", getSecurity()="
				+ getSecurity() + ", getStatus()=" + getStatus() + ", getTrader()=" + getTrader() + ", getBook()="
				+ getBook() + ", getCreationName()=" + getCreationName() + ", getCreationDate()=" + getCreationDate()
				+ ", getRevisionName()=" + getRevisionName() + ", getRevisionDate()=" + getRevisionDate()
				+ ", getDealName()=" + getDealName() + ", getDealType()=" + getDealType() + ", getSourceListId()="
				+ getSourceListId() + ", getSide()=" + getSide() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
