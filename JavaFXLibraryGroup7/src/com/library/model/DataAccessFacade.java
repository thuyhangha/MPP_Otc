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
	/**
	 * 
	 */
	private static final long serialVersionUID = -4736496920387924367L;

	enum StorageType {
		PERSONS, BOOKS, BOOKCOPIES, USERS, AUTHORS, LIBRARYMEMBERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage";

	@Override
	public void addNewPerson(Person person) {
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
	
	public Book searchBook(String isbn) {
		HashMap<String,Book> booksMap =  readBookMap();
		Book b = booksMap.get(isbn);
		return b;
	}
	
	//Book copy
	
	/*public int searchCopyNumber(String isbn, int copyNumber) {
		HashMap<String,Book> booksMap =  readBookMap();
		Book b = booksMap.get(isbn);
	
		for(BookCopy bc: b.getListOfBookCopy()){			
			copyNumber = bc.getCopyNum();
		}
		return copyNumber;
	}*/
	
	public void addBookCopy(String ISBN, BookCopy bookCopy){
		/*HashMap<String, BookCopy> bookCopyMap = readBookCopyMap();
		if (bookCopyMap == null) {
			bookCopyMap = new HashMap<String, BookCopy>();
		}
		String isbn = bookCopy.getBook().getISBN();
		int copyNumber = bookCopy.getCopyNum();
		
		bookCopyMap.put(isbn + copyNumber, bookCopy);
		saveToStorage(StorageType.BOOKCOPIES, bookCopyMap);*/
		HashMap<String, Book> bookMap = getBook();		
		bookMap.get(ISBN).addBookCopy(bookCopy);
		saveToStorage(StorageType.BOOKS, bookMap);
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
		HashMap<String, Book> bookMap = getBook();		
		for(BookCopy bc: bookMap.get(isbn).getListOfBookCopy()){			
			if(bc.getCopyNum() == copyNumber){
				bc.setAvailability(false);
				break;
			}
		}
		saveToStorage(StorageType.BOOKS, bookMap);
	}
	
	@Override
	public void addLibraryMember(LibraryMember libraryMember) {
		HashMap<String, LibraryMember> memberMap = readLibraryMembersMap();
		if (memberMap == null) {
			memberMap = new HashMap<String, LibraryMember>();
		}
		String memberID = libraryMember.getMemberId();
		memberMap.put(memberID, libraryMember);
		saveToStorage(StorageType.LIBRARYMEMBERS, memberMap);
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
		return readLibraryMembersMap();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readLibraryMembersMap() {
		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.LIBRARYMEMBERS);
	}

	@Override
	public void addAuthor(String str, Author author){
		HashMap<String, Author> authorMap = readAuthorMap();
		if (authorMap == null) {
			authorMap = new HashMap<String, Author>();
		}
		String authorID = author.getAuthorId();
		authorMap.put(authorID, author);
		saveToStorage(StorageType.AUTHORS, authorMap);
	}
	
	@Override
	public HashMap<String, Author> getAuthor() {
		return readAuthorMap();
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Author> readAuthorMap() {
		return (HashMap<String, Author>) readFromStorage(StorageType.AUTHORS);
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
