package com.queueintake.model;

public class FastPassToll {

	private String fastPassId;
	private String stationId;
	private Float amountPaid;
	private String status;

	public FastPassToll() {

	}

	public FastPassToll(String fastPassId, String stationId, Float amountPaid) {
		super();
		this.fastPassId = fastPassId;
		this.stationId = stationId;
		this.amountPaid = amountPaid;
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

	public Float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
