package com.mpp.lab9.prob7;

import java.util.List;
import java.util.stream.Collectors;

public class LamdaLibrary {
	
	public static final TriFunction<List<Employee>, Integer, Character, String> valTriFunction =  
			(list, salary, charLastName) -> list.stream().filter(x -> x.getSalary() > salary && x.getLastName().charAt(0) > charLastName)
			.map(x -> x.getFirstName() + " " + x.getLastName())
			.sorted()
			.collect(Collectors.joining(", "));
	
}
