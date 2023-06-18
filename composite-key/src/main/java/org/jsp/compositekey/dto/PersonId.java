package org.jsp.compositekey.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonId implements Serializable {
	private long phone;
	private String email;
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
