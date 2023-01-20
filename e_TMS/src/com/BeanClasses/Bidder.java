package com.BeanClasses;

import java.io.Serializable;
import java.util.Date;

public class Bidder implements Serializable{
	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getTenderId() {
		return tenderId;
	}
	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Date getBidDeadline() {
		return bidDeadline;
	}
	public void setBidDeadline(Date bidDeadline) {
		this.bidDeadline = bidDeadline;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Bidder(String bidId, String vendorId, String tenderId, int bidAmount, Date bidDeadline, String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = bidAmount;
		this.bidDeadline = bidDeadline;
		this.bidStatus = bidStatus;
	}
	private static final long serialVersionUID = 1L;
	private String bidId;
	private String vendorId;
	private String tenderId;
	private int bidAmount;
	private Date bidDeadline;
	private String bidStatus ;
}
