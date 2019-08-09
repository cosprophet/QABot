package com.se1405.beans;

public class TaxiStatus implements Status{
	private String departure = null;
	private String destination = null;
	
	public TaxiStatus() {
		
	}
	
	public TaxiStatus(String dep, String dest) {
		this.departure = dep;
		this.destination = dest;
	}
	
	public String getDeparture() {
		return this.departure;
	}
	
	public void setDeparture(String dep) {
		this.departure = dep;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public void setDestination(String dest) {
		this.destination = dest;
	}
	
	public void setSlotValue(String slot, String value) {
		if(slot == "departure") setDeparture(value);
		else setDestination(value);
	}
	
	
}
