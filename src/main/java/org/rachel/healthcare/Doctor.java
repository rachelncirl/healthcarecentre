package org.rachel.healthcare;

import java.util.Objects;

public class Doctor extends Staff {
	private final int doctorId = IdGenerator.generateId();
	private String areaOfExperiese;

	public Doctor(String firstName, String lastName, Address address, ContactDetails contactDetails, int staffRegistryId, String areaOfExperiese) {
		super(firstName, lastName, address, contactDetails, staffRegistryId);
		this.areaOfExperiese = areaOfExperiese;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public String getAreaOfExperiese() {
		return areaOfExperiese;
	}

	public void setAreaOfExperiese(String areaOfExperiese) {
		this.areaOfExperiese = areaOfExperiese;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Doctor doctor = (Doctor) o;
		return doctorId == doctor.doctorId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctorId);
	}

	@Override
	public String toString() {
		return "Doctor{" +
				"doctorId=" + doctorId +
				", areaOfExperiese='" + areaOfExperiese + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address=" + address +
				", contactDetails=" + contactDetails +
				", staffRegistryId=" + staffRegistryId +
				'}';
	}
}