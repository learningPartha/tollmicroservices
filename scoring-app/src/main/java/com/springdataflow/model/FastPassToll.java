package com.springdataflow.model;

public class FastPassToll {

	private String fastPassId;
	private String stationId;
	private String amountPaid;
	private String status;
	private boolean isFraud;

	public FastPassToll() {

	}

	public FastPassToll(String fastPassId, String stationId, String amountPaid, String status, boolean isFraud) {

		this.fastPassId = fastPassId;
		this.stationId = stationId;
		this.amountPaid = amountPaid;
		this.status = status;
		this.isFraud = isFraud;
	}

	public String getFastPassId() {
		return fastPassId;
	}

	public void setFastPassId(String fastPassId) {
		this.fastPassId = fastPassId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isFraud() {
		return isFraud;
	}

	public void setFraud(boolean isFraud) {
		this.isFraud = isFraud;
	}

}
