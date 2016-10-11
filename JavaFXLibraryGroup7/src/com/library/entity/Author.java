package com.library.entity;

import java.io.Serializable;
import java.util.List;

import com.library.controller.SystemController;

public class Author extends Person implements Serializable{
	private String authorId;
	private String credentials;
	List<Book> book;
	public Author(String ID, String firstName, String lastName, String phone, Address address, String credentials) {
		super(ID, firstName, lastName, phone, address);
		this.authorId = SystemController.getRandom();
		this.credentials = credentials;
	}

	public String getCredentials() {
		return credentials;
	}

	void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getAuthorId() {
		return authorId;
	}
	
}

