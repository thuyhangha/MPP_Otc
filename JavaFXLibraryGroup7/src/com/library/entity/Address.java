package com.library.entity;

import java.io.Serializable;

public class Address implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4915230250042092851L;
	private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
	}
    
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String toString(){
		return "\n Street: " + street + "\n"
				+ " City: " + city + "\n"
				+ " Zip: " + zip;
	}
	

	public String getStreet() {
		return street;
	}

	void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	void setZip(String zip) {
		this.zip = zip;
	}

	public String getStringAddress() {
		return street.trim() + " " + city.trim() + " " + state.trim() + " " + zip.trim();
	}

}