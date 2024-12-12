package org.rachel.healthcare;

import java.util.Objects;

public class ContactDetails {
	private final int id = IdGenerator.generateId();
	private String emailAddress;
	private String phoneNumber;

	public ContactDetails(final String emailAddress, final String phoneNumber) {
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactDetails that = (ContactDetails) o;
		return id == that.id && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(phoneNumber, that.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, emailAddress, phoneNumber);
	}

	@Override
	public String toString() {
		return "ContactDetails{" +
				"id=" + id +
				", emailAddress='" + emailAddress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}