package com.se1405.components;

import java.util.HashMap;

public class NLU {

	public String getIntent(String utterance) {
		if(utterance.contains("车")) {
			return "taxi";
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
		else {
			//other intents
		}
		return sv;
	}
}
