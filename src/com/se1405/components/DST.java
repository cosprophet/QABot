package com.se1405.components;

import java.util.HashMap;
import java.util.Map.Entry;

import com.se1405.components.NLU;
import com.se1405.beans.TaxiStatus;
import com.se1405.beans.RestaurantStatus;
import com.se1405.beans.Turn;
import com.se1405.beans.Status; 

public class DST {

	private static HashMap<Integer, String> userIntents = new HashMap<Integer, String>();
	private static HashMap<Integer, Status> userStatus = new HashMap<Integer, Status>();
	
	public Status updateStatus(Turn turn){
		NLU nlu = new NLU();
		String intent = userIntents.get(turn.getUser().getId());
		Status status = userStatus.get(turn.getUser().getId());
		
		if(intent == null) {
			intent = nlu.getIntent(turn.getUtterance());
			if(intent == null)
				return status;
		}

		if(status == null) {
			if(intent.equals("taxi")) {
				status = new TaxiStatus();
				userIntents.put(turn.getUser().getId(), "taxi");
				userStatus.put(turn.getUser().getId(), status);
			}
			else if(intent.equals("restaurant")){
				status = new RestaurantStatus();
				userIntents.put(turn.getUser().getId(), "restaurant");
				userStatus.put(turn.getUser().getId(), status);
			}
			else {
				//other intents
			}
		}

		HashMap<String, String> sv = nlu.getSlotValues(intent, turn.getUtterance());
        for (Entry<String, String> entry : sv.entrySet()) {
            String slot = entry.getKey();
            String value = entry.getValue();
            status.setSlotValue(slot, value);
        }
        return status;
	}
	
	public boolean deleteStatus(Integer userId) {
		if(userIntents.remove(userId)!=null && userStatus.remove(userId)!=null) return true;
		else return false;
	}
}
