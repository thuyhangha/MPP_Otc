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
		lstBookCopy = new ArrayList<BookCopy>();
	}
	
	public Book(String iSBN, String title, int maxCheckoutLength, List<Author> lstAuthor) {
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.lstAuthor = lstAuthor;
		lstBookCopy = new ArrayList<BookCopy>();
	}
	public Book(String iSBN, String title, int maxCheckoutLength, List<Author> lstAuthor,
			List<BookCopy> lstBookCopy) {
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.lstAuthor = lstAuthor;
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
		return lstAuthor;
	}
	
	public void addBookCopy( BookCopy bc){
		lstBookCopy.add(bc);
	}

	public void setBookCopy(List<BookCopy> listBookCopy) {
		lstBookCopy = listBookCopy;
	}
}
