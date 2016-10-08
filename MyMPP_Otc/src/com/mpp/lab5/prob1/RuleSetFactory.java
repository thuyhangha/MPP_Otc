package com.mpp.lab5.prob1;


import java.awt.Component;
import java.util.HashMap;

public class RuleSetFactory {
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddrWindow.class, new AddressRuleSet());
		map.put(ProfileWindow.class, new ProfileRuleSet());
	}
	public static RuleSet getRuleSet(Component c) {
		Class<? extends Component> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
