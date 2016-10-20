package com.mpp.lab9.prob9;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book= new Book("test", 3);
		List<BookCopy> copies = book.getCopies();
		copies.forEach(copy -> copy.changeAvailability());
		
		//test
		System.out.println(book.isAvailable());
	}

}
