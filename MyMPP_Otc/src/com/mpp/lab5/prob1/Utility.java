package com.mpp.lab5.prob1;

import java.util.regex.Pattern;

public class Utility {

	public static boolean isEmpty(String input){
		if(input.isEmpty())
			return true;
		return false;
	}
	
	public static boolean isNumber(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
	
	public static boolean is5Digits(String input)
    {
       if(input.length() == 5)
    	   return true;
       return false;
    }
	
	public static boolean contain2CharAZ(String input){
		boolean containsAtLeastTwoLetters = Pattern.compile("[0-9].*[0-9]").matcher(input).find();
		
		return containsAtLeastTwoLetters;
	}
	
	public static boolean isEqual(String input1, String input2){
		if(input1.equals(input2))
			return true;
		return false;
	}
}
