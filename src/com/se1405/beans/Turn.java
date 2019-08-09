package com.se1405.beans;

import com.se1405.beans.User;

public class Turn {
	private User user;
	private String utterance;
	
    public Turn(User user, String utterance) {
		this.user = user;
		this.utterance = utterance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUtterance() {
		return utterance;
	}

	public void setUtterance(String utterance) {
		this.utterance = utterance;
	} 
    
}
