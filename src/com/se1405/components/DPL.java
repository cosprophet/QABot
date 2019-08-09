package com.se1405.components;

import com.se1405.beans.Status;
import com.se1405.beans.TaxiStatus;
import com.se1405.beans.SystemAct;
import com.se1405.beans.Turn;
import com.se1405.components.DST;

public class DPL {

	public SystemAct getSystemAct(Turn turn) {
		DST dst = new DST();
		SystemAct sa = new SystemAct();
		
		Status status = dst.updateStatus(turn);
		if(status instanceof TaxiStatus) {
			TaxiStatus taxi = (TaxiStatus)status;
			sa.intent = "taxi";
			if(taxi.getDeparture() == null) {
				sa.act = "askDeparture";
			}
			else if(taxi.getDestination() == null){
				sa.act = "askDestination";
			}
			else {
				sa.act = "success";
			}
		}
		else {
			//other intents
		}
		return sa;
	}

}
