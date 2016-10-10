package com.mpp.lab5.prob1;

import java.awt.Component;

public class AddressRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		AddrWindow addrWindow = (AddrWindow)ob;
		
		String getIdValue = addrWindow.getIdValue().trim();
		String getStreetValue = addrWindow.getStreetValue().trim();
		String getStateValue = addrWindow.getStateValue().trim();
		String getCityValue = addrWindow.getCityValue().trim();
		String getZipValue = addrWindow.getZipValue().trim(); 
		
		if(Utility.isEmpty(getIdValue) || 
				Utility.isEmpty(getStreetValue) ||
				Utility.isEmpty(getStateValue) ||
				Utility.isEmpty(getCityValue) ||
				Utility.isEmpty(getZipValue)) {
			throw new RuleException("All fields must be nonempty");
		}
		
		else if(!Utility.isNumber(getIdValue))
			throw new RuleException("ID field must be numeric");
		else if(!Utility.isNumber(getZipValue))
			throw new RuleException("Zip must be numeric");	
		else if(!Utility.is5Digits(getZipValue))
			throw new RuleException("Zip must be exactly 5 digits");
		else if(!Utility.isAllCapitalsAndExactyEqualNumber(getStateValue, 2))
			throw new RuleException("State field must be exactly 2 digits in A to Z");
		else if(Utility.isEqual(getIdValue, getZipValue))
			throw new RuleException("ID field may not equal zip field");
	}

}
