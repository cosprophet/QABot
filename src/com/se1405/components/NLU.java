package com.se1405.components;

import java.util.HashMap;
import com.se1405.components.RuleBasedIntentClassifier;

public class NLU {
	
	public String getIntent(String utterance) {
		RuleBasedIntentClassifier intentClassifier = new RuleBasedIntentClassifier();
		return intentClassifier.getIntent(utterance);
	}
	
	public HashMap<String, String> getSlotValues(String intent, String utterance) {
		RuleBasedIntentClassifier slotClassifier = new RuleBasedIntentClassifier();
		return slotClassifier.getSlotValues(intent, utterance);
	}
}
