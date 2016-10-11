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
		BOOKS, MEMBERS, USERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage";
	
	private HashMap<String,LibraryMember> libraryMembers = new HashMap<String,LibraryMember>();
	private HashMap<String,Book> books = new HashMap<String,Book>();
	private HashMap<String,Author> authors = new HashMap<String,Author>();
	private HashMap<String, Person> persons = new HashMap<String ,Person>();
	
	private int memberId;


	@Override
	public HashMap<String, LibraryMember> getLibraryMember(){
		return (HashMap<String, LibraryMember>)libraryMembers;
	}

	@Override
	public void addBook(String ISBN, Book book) {
		books.put(ISBN, book);

	}

	@Override
	public HashMap<String, Book> getBook() {
		return books;
	}

	@Override
	public HashMap<String, Author> getAuthor() {
		return (HashMap<String, Author>) authors;
	}

	@Override
	public void addAuthor(String str, Author author){
		authors.put(str, author);
	}

	@Override
	public BookCopy getAvailableBookCopy(String isbn) {
		
		HashMap<String,Book> books = getBook();

		Book book = books.get(isbn);
		
		BookCopy bc = null;
		
		if(book != null){
			List<BookCopy> bookCopyList = book.getListOfBookCopy();
			for(BookCopy b : bookCopyList){
				if(b.getIsAvailable()){		
					return b;
				}
			}
		}
		return bc;
	}

	@Override
	public LibraryMember getLibraryMemberById(String Id) {
		LibraryMember libraryMember = null;
		HashMap<String,LibraryMember> libraryMembers = getLibraryMember();
		libraryMember = libraryMembers.get(Id);
		return libraryMember;
	}

	@Override
	public void setBookCopyAsNotAvailable(String isbn, String copyNumber) {
		
		HashMap<String, Book> hasMap = getBook();		
		for(BookCopy bc: hasMap.get(isbn).getListOfBookCopy()){			
			if(bc.getCopyNum().equals(copyNumber)){
				bc.setAvailable(false);
				break;
			}
		}
	}

	@Override
	public int getMemberId() {
		return memberId;
	}

	@Override
	public void setMemberId(int id) {
		this.memberId = id;
		
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

	@Override
	public void addNewPerson(String personID, Person person) {
		// TODO Auto-generated method stub
		persons.put(personID, person);
	}

	@Override
	public void addLibraryMember(String id, LibraryMember libraryMember) {
		// TODO Auto-generated method stub
		libraryMembers.put(id, libraryMember);
	}
	
}