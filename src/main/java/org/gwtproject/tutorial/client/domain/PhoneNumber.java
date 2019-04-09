package org.gwtproject.tutorial.client.domain;

public class PhoneNumber {

	private String type;
	private String number;

	public PhoneNumber() {
		type = "Mobile";
		number = "08097654321";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
