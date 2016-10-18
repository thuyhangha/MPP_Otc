package com.library.model;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.library.entity.Auth;
import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.LibraryMember;
import com.library.entity.Person;
import com.library.entity.User;

public class DataAccessFacade implements DataAccess, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4736496920387924367L;

	enum StorageType {
		PERSONS, BOOKS, BOOKCOPIES, USERS, AUTHORS, LIBRARYMEMBERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage\\";

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
	
	public BookCopy searchCopyNumberByISBN(String ISBN, BookCopy bookCopy) {
		HashMap<String, Book> bookMap = getBook();	
		List<BookCopy> lstBookCopy = bookMap.get(ISBN).getListOfBookCopy();

		for (BookCopy bookCopyItem : lstBookCopy) {
			if(bookCopyItem.getCopyNum() == bookCopy.getCopyNum()){
				return bookCopy;
			}
		}
		return null;
	}
	
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
	
	////////User
	@Override
	public HashMap<String, User> getUsers(){
		return readUserMap();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		return (HashMap<String, User>)readFromStorage(StorageType.USERS);
	}
	
	@Override
	public void addUsersMap(List<User> userList) {
		HashMap<String, User> map = new HashMap<String, User>();
		userList.forEach(user -> map.put(user.getId(), user));
		saveToStorage(StorageType.USERS, map);
	}
	
	@Override
	public Auth login(String id, String pwd) {
		HashMap<String, User> userMap = readUserMap();
		if(!userMap.containsKey(id)) return null;
		User user = userMap.get(id);
		if(!pwd.equals(user.getPassword())) {
			return null;
		}
		return user.getAuthorization();
	}
	
	/*public void addUser(User user){
		HashMap<String, User> userMap = readUserMap();
		if (userMap == null) {
			userMap = new HashMap<String, User>();
		}
		
		userMap.put(user.getId(), user);
		saveToStorage(StorageType.USERS, user);
	}*/
	////////End User
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			if(Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
				File newFile = new File(path.toString());
				newFile.createNewFile();
			}
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
			if(Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
				return null;
			}
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
