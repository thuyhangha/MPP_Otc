package com.library.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.LibraryMember;
import com.library.entity.Person;

public class DataAccessFacade implements DataAccess, Serializable {
	enum StorageType {
		PERSONS, BOOKS, BOOKCOPIES, MEMBERS, USERS, AUTHORS, LIBRARYMEMBERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage";
	
	private HashMap<String,LibraryMember> libraryMembers = new HashMap<String,LibraryMember>();
	private HashMap<String,Author> authors = new HashMap<String,Author>();
	
	private int memberId;

	@Override
	public void addNewPerson(Person person) {
		// TODO Auto-generated method stub
		HashMap<String, Person> personMap = readPersonsMap();
		if (personMap == null) {
			personMap = new HashMap<String, Person>();
		}
		String personID = person.getID();
		personMap.put(personID, person);
		saveToStorage(StorageType.PERSONS, personMap);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public HashMap<String, Person> getPersons() {
		return readPersonsMap();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Person> readPersonsMap() {
		return (HashMap<String, Person>) readFromStorage(StorageType.PERSONS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readLibraryMembersMap() {
		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.LIBRARYMEMBERS);
	}
	
	@Override
	public void addBook(Book book) {
		HashMap<String, Book> bookMap = readBookMap();
		if (bookMap == null) {
			bookMap = new HashMap<String, Book>();
		}
		String isbn = book.getISBN();
		bookMap.put(isbn, book);
		saveToStorage(StorageType.BOOKS, bookMap);
	}

	@Override
	public HashMap<String, Book> getBook() {
		return readBookMap();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Book> readBookMap() {
		return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
	}
	
	public void addBookCopy(BookCopy bookCopy){
		HashMap<String, BookCopy> bookCopyMap = readBookCopyMap();
		if (bookCopyMap == null) {
			bookCopyMap = new HashMap<String, BookCopy>();
		}
		String isbn = bookCopy.getBook().getISBN();
		int copyNumber = bookCopy.getCopyNum();
		
		bookCopyMap.put(isbn + copyNumber, bookCopy);
		saveToStorage(StorageType.BOOKCOPIES, bookCopyMap);
	}

	public HashMap<String, BookCopy> getBookCopy() {
		return readBookCopyMap();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, BookCopy> readBookCopyMap() {
		return (HashMap<String, BookCopy>) readFromStorage(StorageType.BOOKCOPIES);
	}

	@Override
	public BookCopy getAvailableBookCopy(String isbn) {
		
		HashMap<String,Book> books = getBook();

		Book book = books.get(isbn);
		
		BookCopy bc = null;
		
		if(book != null){
			List<BookCopy> bookCopyList = book.getListOfBookCopy();
			for(BookCopy b : bookCopyList){
				if(b.isAvailable()){		
					return b;
				}
			}
		}
		return bc;
	}
	
	@Override
	public void setBookCopyAsNotAvailable(String isbn, int copyNumber) {
		HashMap<String, Book> hasMap = getBook();		
		for(BookCopy bc: hasMap.get(isbn).getListOfBookCopy()){			
			if(bc.getCopyNum() == copyNumber){
				bc.setAvailability(false);
				break;
			}
		}
	}
	
	@Override
	public LibraryMember getLibraryMemberById(String Id) {
		LibraryMember libraryMember = null;
		HashMap<String,LibraryMember> libraryMembers = getLibraryMember();
		libraryMember = libraryMembers.get(Id);
		return libraryMember;
	}

	@Override
	public HashMap<String, LibraryMember> getLibraryMember(){
		return (HashMap<String, LibraryMember>)libraryMembers;
	}

	@Override
	public void addAuthor(String str, Author author){
		authors.put(str, author);
		saveToStorage(StorageType.AUTHORS, author);
	}
	
	@Override
	public HashMap<String, Author> getAuthor() {
		return (HashMap<String, Author>) authors;
	}

	@Override
	public int getMemberId() {
		return memberId;
	}

	@Override
	public void setMemberId(int id) {
		this.memberId = id;
		
	}
	
	@Override
	public void addLibraryMember(String id, LibraryMember libraryMember) {
		HashMap<String, LibraryMember> memberMap = readLibraryMembersMap();
		if (memberMap == null) {
			memberMap = new HashMap<String, LibraryMember>();
		}
		String memberID = libraryMember.getMemberId();
		memberMap.put(memberID, libraryMember);
		saveToStorage(StorageType.LIBRARYMEMBERS, memberMap);
	}
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
}
