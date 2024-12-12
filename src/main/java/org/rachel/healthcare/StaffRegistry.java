package org.rachel.healthcare;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StaffRegistry {
	private final int id = IdGenerator.generateId();
	private final int healthcareCentreId;
	public Map<Integer, Receptionist> receptionists = new HashMap<>();
	public Map<Integer, Doctor> doctors = new HashMap<>();

	public int getId() {
		return id;
	}

	public StaffRegistry(final int healthcareCentreId) {
		this.healthcareCentreId = healthcareCentreId;
	}

	public int getHealthcareCentreId() {
		return healthcareCentreId;
	}

	public Map<Integer, Doctor> getDoctors() {
		return doctors;
	}

	public void addDoctor(Doctor doctor) {
		doctors.put(doctor.getId(), doctor);
	}

	public void removeDoctor(Doctor doctor) {
		doctors.remove(doctor.getId());
	}

	public Staff getDoctor(final int id) {
		return this.doctors.get(id);
	}

	public Map<Integer, Receptionist> getReceptionists() {
		return receptionists;
	}

	public void addReceptionist(Receptionist receptionist) {
		receptionists.put(receptionist.getId(), receptionist);
	}

	public void removeReceptionist(Receptionist receptionist) {
		receptionists.remove(receptionist.getId());
	}

	public Receptionist getReceptionist(final int id) {
		return this.receptionists.get(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StaffRegistry that = (StaffRegistry) o;
		return id == that.id && healthcareCentreId == that.healthcareCentreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, healthcareCentreId);
	}

	@Override
	public String toString() {
		return "StaffRegistry{" +
				"id=" + id +
				", healthcareCentreId=" + healthcareCentreId +
				", doctors=" + doctors +
				", receptionists=" + receptionists +
				'}';
	}
}