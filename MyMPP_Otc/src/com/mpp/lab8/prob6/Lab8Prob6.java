package com.mpp.lab8.prob6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lab8Prob6 {
	EmployeeNameComparator comp = new EmployeeNameComparator();
	public static void main(String[] args) {
		Lab8Prob6 pro = new Lab8Prob6();
		pro.evaluator();
	}
	
	public void evaluator(){
		Employee emp = new Employee("test", 4000);
		
		/*A. (Employee e) -> e.getName()*/
		Function<Employee, String> getName1 = (Employee e) -> e.getName();
		Function<Employee, String> getName2 = Employee::getName;
		//type 1: Object::instance  method 
		System.out.println(getName1.apply(emp) + " - " + getName2.apply(emp));
		
		/*B. (Employee e,String s) -> e.setName(s)*/
		BiConsumer<Employee, String> setName1 = (Employee e,String s) -> e.setName(s);
		BiConsumer<Employee, String> setName2 = Employee::setName;
		//type 3: Class::instance  method
		setName1.accept(emp, "new Name");
		setName2.accept(emp, "new Name 2");
		System.out.println(getName1.apply(emp));
		
		/*C. (String s1,String s2) -> s1.compareTo(s2)*/
		BiFunction<String, String, Integer> compareTo1 = (String s1,String s2) -> s1.compareTo(s2);
		BiFunction<String, String, Integer> compareTo2 = String::compareTo;
		//type 3: Class::instance  method 	
		System.out.println(compareTo1.apply("test1", "test1") + " - " + compareTo2.apply("test1", "test1"));
		
		/*D. (Integer x,Integer y) -> Math.pow(x,y)*/
		BiFunction<Integer, Integer, Double> pow1 = (Integer x,Integer y) -> Math.pow(x,y);
		BiFunction<Integer, Integer, Double> pow2 = Math::pow;
		//type 2: Class::static method 
		System.out.println(pow1.apply(2, 3) + " - " + pow2.apply(2, 3));
		
		/*E. (Apple a) -> a.getWeight()*/
		Function<Apple, Double> getWeight1 = (Apple a) -> a.getWeight();
		Function<Apple, Double> getWeight2 = Apple::getWeight;
		//type 1: Object::instance method 
		System.out.println(getWeight1.apply(new Apple(5.0)) + " - " + getWeight2.apply(new Apple(5.0)));
		
		/*F. (String x) -> Integer.parseInt(x);*/
		Function<String, Integer> parseInt1 = (String x) -> Integer.parseInt(x);
		Function<String, Integer> parseInt2 = Integer::parseInt;
		//type 1: Class::static method
		
		/*		
		G. EmployeeNameComparator comp = new EmployeeNameComparator(); 
		(Employee e1, Employee e2) -> comp.compare(e1,e2)*/
		Employee emp1 = new Employee("test", 4000);
		Employee emp2 = new Employee("test", 4000);
		
		BiFunction<Employee, Employee, Integer> compare1 = (Employee e1, Employee e2) -> comp.compare(e1,e2);
		BiFunction<Employee, Employee, Integer> compare2 = comp::compare;
		//type 3: Class::instance method
		System.out.println(compare1.apply(emp1, emp2) + " - " + compare2.apply(emp1, emp2));
	}
	
	public class EmployeeNameComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.name.compareTo(o2.name);
		}
		
	}
}
