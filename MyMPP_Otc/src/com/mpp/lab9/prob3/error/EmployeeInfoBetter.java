package com.mpp.lab9.prob3.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class EmployeeInfoBetter {
	static enum SortMethod {BYNAME, BYSALARY};
	//Function<Employee, Employee> byEmp = e -> e;
	Function<Employee, String> byName = e -> e.getName();
	Function<Employee, Integer> bySalary = e -> e.getSalary();
	
	public void sort(HashMap<Employee, Employee> emps, final SortMethod method) {
		if(method == SortMethod.BYNAME) {
			Collections.sort((List)emps.get(emps.keySet()), Comparator.comparing(byName).thenComparing(bySalary));
		} else {
			Collections.sort((List)emps.get(emps.keySet()), Comparator.comparing(bySalary).thenComparing(byName));
		}			
	}
	
	public static HashMap<Employee, Employee> mapEmp = new HashMap<Employee, Employee>();
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		
		emps.forEach(x -> mapEmp.put(x, x));
		
		EmployeeInfoBetter ei = new EmployeeInfoBetter();
		ei.sort(mapEmp, EmployeeInfoBetter.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(mapEmp, EmployeeInfoBetter.SortMethod.BYSALARY);
		//System.out.println(emps);
	}
}
