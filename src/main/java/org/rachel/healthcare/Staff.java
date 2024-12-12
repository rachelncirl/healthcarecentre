package org.rachel.healthcare;

public abstract class Staff {

	private final int id = IdGenerator.generateId();
	protected String firstName;
	protected String lastName;
	protected Address address;
	protected ContactDetails contactDetails;
	protected int staffRegistryId;

	public Staff(String firstName, String lastName, Address address, ContactDetails contactDetails, int staffRegistryId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactDetails = contactDetails;
		this.staffRegistryId = staffRegistryId;
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

	public int getStaffRegistryId() {
		return staffRegistryId;
	}

	public void setStaffRegistryId(int staffRegistryId) {
		this.staffRegistryId = staffRegistryId;
	}
}