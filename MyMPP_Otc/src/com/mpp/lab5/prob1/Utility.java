package com.mpp.lab5.prob1;

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
	
	public static boolean isEqual(String input1, String input2){
		if(input1.equals(input2))
			return true;
		return false;
	}
	
	public static boolean containCharacterazAZNoSpaces(String input)
	{
		if(!input.trim().equals(input)){
			return false;
		}
	
		for(int i=0;i<input.length();i++)
		{		
			if(!Character.isLetter(input.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isAllCapitalsAndExactyEqualNumber(String input, int number)
	{
		int count = 0;
		for(int i=0;i<input.length();i++)
		{		
			if(Character.isUpperCase(input.charAt(i)))
			{
				count ++;
			}
		}
		if(count == number && count == input.length())
			return true;
		return false;
	}
}
