package com.pluralsight.tollrateservice.model;

public class TollRatev2 {

	private Integer stationId;
	private Float currentRate;
	private String timestamp;
	private boolean isBaseRate;

	public TollRatev2() {
	}

	public TollRatev2(Integer stationId, Float currentRate, String timestamp, boolean isBaseRate) {
		this.stationId = stationId;
		this.currentRate = currentRate;
		this.timestamp = timestamp;
		this.isBaseRate = isBaseRate;
	}

	public Integer getStationId() {
		return stationId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Float getCurrentRate() {
		return currentRate;
	}

	public void setCurrentRate(Float currentRate) {
		this.currentRate = currentRate;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public boolean isBaseRate() {
		return isBaseRate;
	}

	public void setBaseRate(boolean isBaseRate) {
		this.isBaseRate = isBaseRate;
	}

}
