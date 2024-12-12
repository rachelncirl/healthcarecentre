package org.rachel.healthcare;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PatientRegistry {
	private final int id = IdGenerator.generateId();
	private final int healthcareCentreId;
	private Map<Integer,Patient> patients = new HashMap<>();

	public PatientRegistry(int healthcareCentreId) {
		this.healthcareCentreId = healthcareCentreId;
	}

	public int getId() {
		return id;
	}

	public int getHealthcareCentreId() {
		return healthcareCentreId;
	}

	public Map<Integer, Patient> getPatients() {
		return patients;
	}

	public void addPatient(Patient patient) {
		this.patients.put(patient.getId(), patient);
	}

	public void removePatient(Patient patient) {
		this.patients.remove(patient.getId());
	}

	public Patient getPatient(final int id) {
		return patients.get(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PatientRegistry that = (PatientRegistry) o;
		return id == that.id && healthcareCentreId == that.healthcareCentreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, healthcareCentreId);
	}

	@Override
	public String toString() {
		return "PatientRegistry{" +
				"id=" + id +
				", healthcareCentreId=" + healthcareCentreId +
				", patients=" + patients +
				'}';
	}
}