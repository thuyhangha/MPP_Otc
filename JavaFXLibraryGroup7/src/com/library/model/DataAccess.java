package com.library.model;

import java.util.HashMap;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.LibraryMember;
import com.library.entity.Person;

public interface DataAccess {
	
	public void addNewPerson(String personID, Person person);
	
	public void addLibraryMember(String id, LibraryMember libraryMember);

	public HashMap<String, LibraryMember> getLibraryMember();
	
	public LibraryMember getLibraryMemberById(String id);

	public void addBook(String ISBN, Book book);

	public HashMap<String, Book> getBook();
	
	public void addAuthor(String str, Author author);
	
	public HashMap<String, Author> getAuthor();
	
	public BookCopy getAvailableBookCopy(String isbn);
	
	public void setBookCopyAsNotAvailable(String isbn, String copyNumber);
	
	public int getMemberId();
	
	public void setMemberId(int id);

}
