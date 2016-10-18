package com.library.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.library.entity.Address;
import com.library.entity.Auth;
import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.LibraryMember;
import com.library.entity.User;

public class TestData {
	
	@SuppressWarnings("serial")
	public final List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
	
	@SuppressWarnings("serial")
	public final List<Author> allAuthors = new ArrayList<Author>() {
		{
			
			add(new Author("111", "Joe", "Thomas", "641123450", addresses.get(1), "A happy man is he.", ""));
			add(new Author("112", "Sandra", "Thomas", "641123451", addresses.get(2), "A happy wife is she.", ""));
			add(new Author("113", "Nirmal", "Pugh", "641123452", addresses.get(3), "Thinker of thoughts.", ""));
			add(new Author("114", "Andrew", "Cleveland", "641123453", addresses.get(4), "Author of childrens' books.", ""));
			add(new Author("115", "Sarah", "Connor", "641123456", addresses.get(5), "Known for her clever style.", ""));
		}
	};
	
	//create library members
	@SuppressWarnings("serial")
	public List<LibraryMember> allLibraryMember = new ArrayList<LibraryMember>(){
		{
			LibraryMember member = new LibraryMember("1", "Thuy Hang", "Ha", "6411112345", addresses.get(4), "1001");
			add(member);
			member = new LibraryMember("2", "Hang", "Ha", "6411112346", addresses.get(6), "1002");
			add(member);
			member = new LibraryMember("3", "Jenny", "Ha", "6411112347", addresses.get(7), "1003");
			add(member);
			member = new LibraryMember("3", "Sarah", "Pugh", "6411112348", addresses.get(1), "1004");
			add(member);
		}
	};
	
	@SuppressWarnings("serial")
	public final List<Book> allBooks = new ArrayList<Book>() {
		{
//			public Book(String iSBN, String title, int maxCheckoutLength, List<Author> lstAuthor)
			add(new Book("11-12345", "The Big Fish", 21, allAuthors.get(0)));
			add(new Book("12-23456", "Antartica", 7, allAuthors.get(2)));
			add(new Book("13-34567", "Thinking Java", 21, allAuthors.get(3)));
			add(new Book("14-45678", "Jimmy's First Day of School", 7, allAuthors.get(4)));
		}
	};
	
	@SuppressWarnings("serial")
	public final List<BookCopy> allBookCopy = new ArrayList<BookCopy>(){
		{
			add(new BookCopy(allBooks.get(0), 1));
			add(new BookCopy(allBooks.get(0), 2));
			add(new BookCopy(allBooks.get(1), 1));
			add(new BookCopy(allBooks.get(1), 2));
			add(new BookCopy(allBooks.get(1), 3));
			add(new BookCopy(allBooks.get(2), 1));
			add(new BookCopy(allBooks.get(3), 1));
		}
	};
	
	private void addBookCopyForBook() {
		allBooks.get(0).addBookCopy(allBookCopy.get(0));
		allBooks.get(0).addBookCopy(allBookCopy.get(1));
		allBooks.get(1).addBookCopy(allBookCopy.get(2));
		allBooks.get(1).addBookCopy(allBookCopy.get(3));
		allBooks.get(1).addBookCopy(allBookCopy.get(4));
		allBooks.get(2).addBookCopy(allBookCopy.get(5));
		allBooks.get(3).addBookCopy(allBookCopy.get(6));
	}
	
	public final List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("101", "xyz", Auth.LIBRARIAN));
			add(new User("102", "abc", Auth.ADMIN));
			add(new User("103", "111", Auth.BOTH));
		}
	};
	
	
	public void addDummyData() {
		addBookCopyForBook();
		DataAccess dataAccess = new DataAccessFacade();
		for (LibraryMember member : allLibraryMember) {
			dataAccess.addLibraryMember(member);
		}
		for (Book book : allBooks) {
			dataAccess.addBook(book);
		}
		dataAccess.addUsersMap(allUsers);
	}
}