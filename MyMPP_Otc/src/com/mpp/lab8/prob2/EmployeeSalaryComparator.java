package com.mpp.lab8.prob2;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if(Integer.compare(e1.salary, e2.salary) != 0)
			return Integer.compare(e1.salary, e2.salary);
		else {
			return e1.name.compareTo(e2.name);
		}
	}
}
