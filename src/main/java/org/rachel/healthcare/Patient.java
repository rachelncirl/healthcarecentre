package org.rachel.healthcare;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {
	private final int id = IdGenerator.generateId();
	private String firstName;
	private String lastName;
	private final LocalDate dateOfBirth;
	private String sex;
	private final LocalDate registrationDate;
	private Address address;
	private ContactDetails contactDetails;
	private final int patientRegistryId;
	private final MedicalHistory medicalHistory;
	private final Account account;

	public Patient(final String firstName, final String lastName, final LocalDate dateOfBirth, final String sex, final Address address,
				   final ContactDetails contactDetails, final int patientRegistryId, final int healthCareCentreId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.address = address;
		this.contactDetails = contactDetails;
		this.patientRegistryId = patientRegistryId;
		this.registrationDate = LocalDate.now();
		this.medicalHistory = new MedicalHistory(this.id);
		this.account = new Account(0, id, healthCareCentreId);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public int getPatientRegistryId() {
		return patientRegistryId;
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public Account getAccount() {
		return account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patient patient = (Patient) o;
		return id == patient.id && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(medicalHistory, patient.medicalHistory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, dateOfBirth, medicalHistory);
	}

	@Override
	public String toString() {
		return "Patient{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", sex='" + sex + '\'' +
				", registrationDate=" + registrationDate +
				", address=" + address +
				", contactDetails=" + contactDetails +
				", patientRegistryId=" + patientRegistryId +
				", medicalHistory=" + medicalHistory +
				", account=" + account +
				'}';
	}
}