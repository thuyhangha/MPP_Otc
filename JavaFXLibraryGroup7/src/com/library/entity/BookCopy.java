package com.library.entity;

import java.io.Serializable;

import com.library.controller.SystemController;

public class BookCopy implements Serializable {
	
	private String copyNum;
	boolean isAvailable;
	Book book;
	
	public BookCopy(Book book, String copyNumber, boolean isAvailable) {
	        this.book = book;
	        this.copyNum = copyNumber;
	        this.isAvailable = true;
	}

	public String getCopyNum() {
		return copyNum;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
