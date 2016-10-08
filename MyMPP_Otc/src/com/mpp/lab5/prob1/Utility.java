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
	
	/*public static boolean contain2CharAZ(String input){
		boolean containsAtLeastTwoLetters = Pattern.compile("[0-9].*[0-9]").matcher(input).find();
		
		return containsAtLeastTwoLetters;
	}*/
	
	public static boolean isEqual(String input1, String input2){
		if(input1.equals(input2))
			return true;
		return false;
	}
	
	public static boolean containCharacterazAZNoSpaces(String input, int number)
	{
		if(!input.trim().equals(input)){
			return false;
		}
		
		int count = 0;
		for(int i=0;i<input.length();i++)
		{		
			if(Character.isLetter(input.charAt(i)))
			{
				count ++;
			}
		}
		if(count == number)
			return true;
		return false;
	}

	public static boolean isAllCapitals(String input, int number)
	{
		int count = 0;
		for(int i=0;i<input.length();i++)
		{		
			if(Character.isUpperCase(input.charAt(i)))
			{
				count ++;
			}
		}
		if(count == number)
			return true;
		return false;
	}
}
