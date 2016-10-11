package com.library.entity;

import java.time.LocalDate;

public class CheckoutRecordEntry {
	private String ID;
	private LocalDate checkoutDate;
	private BookCopy bookCopy;
	private LocalDate dueDate;
	
	public CheckoutRecordEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
