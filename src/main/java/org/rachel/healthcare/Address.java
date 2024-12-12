package org.rachel.healthcare;

import java.util.Objects;

public class Address {
	private final int id = IdGenerator.generateId();
	private final String street;
	private final String city;
	private final String county;
	private final String postalCode;

	public Address(final String street, final String city, final String county, final String postalCode) {
		this.street = street;
		this.city = city;
		this.county = county;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return id == address.id && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(county, address.county) && Objects.equals(postalCode, address.postalCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, street, city, county, postalCode);
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", county='" + county + '\'' +
				", postalCode='" + postalCode + '\'' +
				'}';
	}
}