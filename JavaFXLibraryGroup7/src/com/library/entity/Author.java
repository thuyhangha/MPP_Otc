package com.library.entity;

import java.io.Serializable;
import java.util.List;

import com.library.controller.SystemController;
import com.library.utility.Utility;

public class Author extends Person implements Serializable{
	private String authorId;
	private String credentials;
	private String shortBio;
	List<Book> book;
	public Author(String ID, String firstName, String lastName, String phone, Address address, String credentials, String shortBio) {
		super(ID, firstName, lastName, phone, address);
		this.authorId = Utility.getRandom();
		this.credentials = credentials;
		this.shortBio = shortBio;
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

	String getShortBio() {
		return shortBio;
	}

	void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
	
}

