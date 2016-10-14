package com.library.entity;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3540726049858167589L;
	private String memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String ID, String firstName, String lastName, String phone, Address address, String memberId) {
		super(ID, firstName, lastName, phone, address);
		this.memberId = memberId;
		this.checkoutRecord = new CheckoutRecord();
	}

	public String getMemberId() {
		return memberId;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	
	public void setCheckoutRecord(CheckoutRecord c){
		checkoutRecord = c;
	}

	public String toString(){
		return "\n Member ID: " + memberId + "\n"
				+ super.toString() + "\n"
				+ checkoutRecord.toString();

	}

}
