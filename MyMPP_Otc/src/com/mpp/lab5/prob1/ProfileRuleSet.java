package com.mpp.lab5.prob1;

import java.awt.Component;

public class ProfileRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		ProfileWindow profileWindow = (ProfileWindow)ob;

		String id = profileWindow.getIdValue();
		String firstName = profileWindow.getFirstNameValue();
		String lastName = profileWindow.getLastNameValue();
		String favoriteMovie = profileWindow.getFavoriteMovieValue();
		String favoriteRestaurant = profileWindow.getFavoriteRestaurantValue();
		
		if(Utility.isEmpty(id) ||
				Utility.isEmpty(firstName) ||
				Utility.isEmpty(lastName) ||
				Utility.isEmpty(favoriteMovie) ||
				Utility.isEmpty(favoriteRestaurant)) {
			throw new RuleException("All fields must be non empty");
		}
		
		else if(Utility.isEqual(favoriteMovie, favoriteRestaurant))
			throw new RuleException("Favorite restaurant cannot equal favorite movie");			

		else if(!Utility.isNumber(id))
			throw new RuleException("ID field must be numeric");
		
		else if(!Utility.containCharacterazAZNoSpaces(firstName))
			throw new RuleException("First Name field may not contain spaces or characters other than a-z, A-Z");
		
		else if(!Utility.containCharacterazAZNoSpaces(lastName))
			throw new RuleException("Last Name field may not contain spaces or characters other than a-z, A-Z");
		
	}
}
