package org.rachel.healthcare;

import java.util.Objects;

public class Receptionist extends Staff {

	private final int receptionistID = IdGenerator.generateId();

	public Receptionist(String firstName, String lastName, Address address, ContactDetails contactDetails, int staffRegistryId) {
		super(firstName, lastName, address, contactDetails, staffRegistryId);
	}

	public int getReceptionistID() {
		return receptionistID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Receptionist that = (Receptionist) o;
		return receptionistID == that.receptionistID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(receptionistID);
	}

	@Override
	public String toString() {
		return "Receptionist{" +
				"receptionistID=" + receptionistID +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address=" + address +
				", contactDetails=" + contactDetails +
				", staffRegistryId=" + staffRegistryId +
				'}';
	}
}