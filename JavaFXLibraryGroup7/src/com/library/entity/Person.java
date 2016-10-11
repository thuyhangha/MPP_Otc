package com.library.entity;

import java.io.Serializable;
import java.util.Set;

public class Person implements Serializable{
	
	private String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private Address address;
	private Set<UserRole> roles;
	
	public Person(String ID, String firstName, String lastName, String phone, Address address) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "\n FirstName: " + firstName + "\n" + " LastName: " + lastName + "\n" + " Phone: " + phone
				+ address.toString();
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String getID() {
		return ID;
	}
}
