package com.se1405.components;

import java.util.HashMap;

public class NLU {

	public String getIntent(String utterance) {
		if(utterance.contains("车")) {
			return "taxi";
		}
		else if(utterance.contains("订")) {
			return "restaurant";
		}
		return null;
	}
	
	public HashMap<String, String> getSlotValues(String intent, String utterance) {
		HashMap<String, String> sv = new HashMap<String, String>();
		if(intent=="taxi") {
			if(utterance.contains("从")) {
				int index = utterance.indexOf("从");
				String dep = utterance.substring(index+1, index+3);
				sv.put("departure", dep);
			}
			if(utterance.contains("到")) {
				int index = utterance.indexOf("到");
				String dest = utterance.substring(index+1, index+3);
				sv.put("destination", dest);
			}
		}
		else if(intent == "restaurant") {
			if(utterance.contains("日") || utterance.contains("号")) {
				int index = utterance.indexOf("日");
				if(index == -1) {
					index = utterance.indexOf("号");
				}
				String day = utterance.substring(index-3, index+1);
				sv.put("day", day);
			}
			if(utterance.contains(":")) {
				int index = utterance.indexOf(":");
				String time = utterance.substring(index-1, index+2);
				sv.put("time", time);
			}
			if(utterance.contains("人")) {
				int index = utterance.indexOf("人");
				String people = utterance.substring(index-1, index);
				sv.put("people", people);
			}
		}
		else {
			//other intents
		}
		return sv;
	}
}
