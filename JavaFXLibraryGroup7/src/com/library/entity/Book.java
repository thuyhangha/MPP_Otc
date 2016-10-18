package com.library.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 110915195267804607L;
	private String ISBN;
	private String title;
	private int maxCheckoutLength;
	private List<Author> lstAuthor;
	private List<BookCopy> lstBookCopy;
	
	public Book(String iSBN, String title, int maxCheckoutLength) {
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		lstAuthor = new ArrayList<Author>();
		lstBookCopy = new ArrayList<BookCopy>();
	}
	
	public Book(String iSBN, String title, int maxCheckoutLength, Author author) {
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		lstAuthor = new ArrayList<Author>();
		lstAuthor.add(author);
		lstBookCopy = new ArrayList<BookCopy>();
	}
	public Book(String iSBN, String title, int maxCheckoutLength, Author author,
			List<BookCopy> lstBookCopy) {
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		lstAuthor = new ArrayList<Author>();
		lstAuthor.add(author);
		this.lstBookCopy = lstBookCopy;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public List<BookCopy> getListOfBookCopy() {
		return lstBookCopy;
	}

	public List<Author> getListOfAuthors() {
		return getLstAuthor();
	}
	
	public void addBookCopy( BookCopy bc){
		lstBookCopy.add(bc);
	}

	public void setBookCopy(List<BookCopy> listBookCopy) {
		lstBookCopy = listBookCopy;
	}

	public List<Author> getLstAuthor() {
		return lstAuthor;
	}
}
