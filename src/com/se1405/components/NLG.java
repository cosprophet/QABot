package com.se1405.components;

import com.se1405.beans.Turn;
import com.se1405.components.DPL;
import com.se1405.components.DST;
import com.se1405.beans.SystemAct; 

public class NLG {

	public String nlg(Turn turn) {
		DPL dpl = new DPL();
		SystemAct sa = dpl.getSystemAct(turn);
		if(sa.intent == "taxi") {
			if(sa.act == "askDeparture") {
				return "请问您要从哪里出发呢？";
			}
			else if(sa.act == "askDestination") {
				return "请问您要到哪里去呢？";
			}
			else {
				new DST().deleteStatus(turn.getUser().getId());
				return "叫车成功！";
			}
		}
		else {
			//other skill
		}
		return "无法识别您的输入";
	}

}
