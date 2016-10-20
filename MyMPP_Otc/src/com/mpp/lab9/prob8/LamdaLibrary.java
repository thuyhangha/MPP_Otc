package com.mpp.lab9.prob8;

import java.util.List;
import java.util.stream.Collectors;

public class LamdaLibrary {
	
	/*Long numEmployee = list.stream().filter(x -> x.getSalary() > 100000 && x.lastName.charAt(0) > 'E').count();
	System.out.println(numEmployee);	*/
	public static final TriFunction<List<Employee>, Integer, Character, Long> numEmployeeTriFunction =  
			(list, salary, charLastName) -> list.stream().filter(x -> x.getSalary() > 100000 && x.lastName.charAt(0) > 'E').count();
			
	/*List<String> sortFullNameValue = list.stream().filter(x -> x.salary > 8500 && x.firstName.charAt(0) > 'R')
					  .map(x -> x.getFirstName().toUpperCase())
					  .collect(Collectors.toList());*/
	public static final TriFunction<List<Employee>, Integer, Character, List<String>> sortFullNameTriFunction =  
			(list, salary, charLastName) -> list.stream().filter(x -> x.salary > 8500 && x.firstName.charAt(0) < 'R')
			  .map(x -> x.getFirstName().toUpperCase())
			  .collect(Collectors.toList());
}
