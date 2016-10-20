package EXCERSICE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		//load up some test data
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim", "68306");
		Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
		
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);

		//in-class exercise 1
		//get all names of customers whose city of residence begins 
		//with "Ma", in sorted order
		Function<Customer, String> getName = x ->x.getName(); 
		List<String> stream = list.stream()
									.filter(x->x.getCity().startsWith("Ma"))
									.map(getName)
									.sorted().collect(Collectors.toList());
		/*List<Customer> myList = list.stream()
				.filter(x->x.getCity().startsWith("Ma"))
				.sorted(Comparator.comparing(getName))
				.collect(Collectors.toList());*/
		
		//in-class exercise 2
		//get all customers who live in Fairfield and sort by their name in descending order
		Function<Customer, String> getStreet = x ->x.getStreet(); 
		/*Stream<Customer> streamCity = list.stream()
											.filter(x->x.getCity().equals("Fairfield"))
											.sorted(Comparator.comparing(getName).reversed());*/
		Comparator<Customer> comparator = (c1, c2) ->c2.getName().compareTo(c1.getName());
		Comparator<Customer> compa1= Comparator.comparing(getName).reversed();
		Stream<Customer> streamCity = list.stream().filter(x->x.getCity().equals("Fairfield")).sorted(comparator);
			
		
		//concat
		/*
		Optional<String> myConcat = Stream.of("My name is ", "Hang", "Ha").reduce((x, y) -> x.concat(y));
		if(myConcat.isPresent())
			System.out.println(myConcat.get());*/
		
		Stream<String> stream1 = Stream.of("test ", "yest", "abc");
		String s= stream1.reduce("", (String x, String y) -> {
			StringBuilder streambuider = new StringBuilder();
			streambuider.append(x);
			streambuider.append(" ");
			streambuider.append(y);
			return streambuider.toString();
		});
		
		//put function
		BiFunction<List<Customer>, String, List<String>> valBiFunction = 
				(mylist, startLetter) -> {
					return mylist.stream()
					.filter(x->x.getCity().startsWith(startLetter))
					.map(getName)
					.sorted().collect(Collectors.toList());
				}; 
		System.out.println(valBiFunction.apply(list, "Ma"));		
		list.stream().filter(x->x.getCity().equals("")).sorted(Comparator.comparing(getName).reversed()).collect(Collectors.toList());
		list.stream().filter(x->x.getCity().equals("Ma")).sorted(Comparator.comparing(getName).reversed()).collect(Collectors.toList());
		
		list.stream()
		.filter(x->x.getCity().equals(""))
		.sorted(Comparator.comparing(getName).reversed())
		.collect(Collectors.toList());
		
		BiFunction<List<Customer>, String, List<Customer>> getCityBiFunction = 
				(mylist, city) -> {
					return mylist.stream()
							.filter(x->x.getCity().equals(city))
							.sorted(Comparator.comparing(getName).reversed())
							.collect(Collectors.toList());
				}; 
				
				
		System.out.println(valBiFunction.apply(list, "Ma"));
		System.out.println(getCityBiFunction.apply(list, "Fairfield"));
	}

}
