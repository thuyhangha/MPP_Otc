package com.library.entity;

import java.io.Serializable;

public class UserAccount implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2143089540153440154L;
	private Person person;
    private String username;
    private String password;

    public UserAccount(Person person, String username, String password) {
        this.person = person;
        this.username = username;
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
