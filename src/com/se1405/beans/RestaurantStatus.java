package com.se1405.beans;

public class RestaurantStatus implements Status{
	private String day = null;
	private String time = null;
	private int people = 0;
	
	public RestaurantStatus() {}
	
	public RestaurantStatus(String day, String time, int people) {
		this.day = day;
		this.time = time;
		this.people = people;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getPeople() {
		return people;
	}


	public void setPeople(int people) {
		this.people = people;
	}


	public void setSlotValue(String slot, String value) {
		if(slot == "day") setDay(value);
		else if(slot == "time") setTime(value);
		else if(slot == "people") {
			try {
				setPeople(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				
			}finally {
				setPeople(5);
			}
		}
		
	}
	
}
