package com.library.entity;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	private int memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String ID, String firstName, String lastName, String phone, Address address, int memberId,
			CheckoutRecord checkoutRecord) {
		super(ID, firstName, lastName, phone, address);
		this.memberId = memberId;
		this.checkoutRecord = checkoutRecord;
	}

	public int getMemberId() {
		return memberId;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	
	void setCheckoutRecord(CheckoutRecord c){
		checkoutRecord = c;
	}

	public String toString(){
		return "\n Member ID: " + memberId + "\n"
				+ super.toString() + "\n"
				+ checkoutRecord.toString();

	}

}
