package com.library.model;

import java.util.HashMap;
import java.util.List;

import com.library.entity.Auth;
import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.LibraryMember;
import com.library.entity.Person;
import com.library.entity.User;

public interface DataAccess {
	
	public void addNewPerson(Person person);
	
	public HashMap<String, Person> getPersons();
	
	public void addLibraryMember(LibraryMember libraryMember);

	public HashMap<String, LibraryMember> getLibraryMember();
	
	public LibraryMember getLibraryMemberById(String id);

	public void addBook(Book book);

	public HashMap<String, Book> getBook();
	
	public void addBookCopy(String ISBN, BookCopy bookCopy);

	public HashMap<String, BookCopy> getBookCopy();
	
	public void addAuthor(String str, Author author);
	
	public HashMap<String, Author> getAuthor();
	
	public BookCopy getAvailableBookCopy(String isbn);
	
	public void setBookCopyAsNotAvailable(String isbn, int copyNumber);
	
	public Book searchBook(String isbn);

	public BookCopy searchCopyNumberByISBN(String ISBN, BookCopy bookCopy);
	
	public Auth login(String id, String pwd);

	public HashMap<String, User> getUsers();

	void addUsersMap(List<User> userList);
}
