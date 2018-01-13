package com.briup.bean;

public class Phone {
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return this.getPhoneNumber();
	}

	public Phone(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}
	public Phone() {
	}
}
