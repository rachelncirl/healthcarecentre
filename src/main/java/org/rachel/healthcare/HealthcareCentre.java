package org.rachel.healthcare;

import java.util.ArrayList;
import java.util.Objects;

public class HealthcareCentre {
	private final int id = IdGenerator.generateId();
	private String name;
	private Address address;
	private final PatientRegistry patientRegistry;
	private final StaffRegistry staffRegistry;
	private final AppointmentSchedule appointmentSchedule;
	private ContactDetails contactDetails;
	private final ArrayList<Account> accounts = new ArrayList<Account>();

	public HealthcareCentre(final String name, final Address address, final ContactDetails contactDetails) {
		this.name = name;
		this.address = address;
		this.contactDetails = contactDetails;
		this.patientRegistry = new PatientRegistry(this.id);
		this.staffRegistry = new StaffRegistry(this.id);
		this.appointmentSchedule = new AppointmentSchedule(this.id);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PatientRegistry getPatientRegistry() {
		return patientRegistry;
	}

	public StaffRegistry getStaffRegistry() {
		return staffRegistry;
	}

	public AppointmentSchedule getAppointmentSchedule() {
		return appointmentSchedule;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HealthcareCentre that = (HealthcareCentre) o;
		return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(contactDetails, that.contactDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address, contactDetails);
	}

	@Override
	public String toString() {
		return "HealthcareCentre{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address=" + address +
				", patientRegistry=" + patientRegistry +
				", staffRegistry=" + staffRegistry +
				", appointmentScheduleId=" + appointmentSchedule +
				", contactDetails=" + contactDetails +
				", accounts=" + accounts +
				'}';
	}
}