package org.rachel.healthcare;

import java.util.ArrayList;
import java.util.Objects;

public class MedicalHistory {
	private final int id = IdGenerator.generateId();
	private String currentHealthStatus;
	private String allergies;
	private final int patientId;
	private final ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

	public MedicalHistory(int patientId) {
		this.patientId = patientId;
		this.currentHealthStatus = "N/A";
		this.allergies = "N/A";
	}

	public int getId() {
		return id;
	}

	public String getCurrentHealthStatus() {
		return currentHealthStatus;
	}

	public void setCurrentHealthStatus(String currentHealthStatus) {
		this.currentHealthStatus = currentHealthStatus;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public int getPatientId() {
		return patientId;
	}

	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void addMedicalRecord(final MedicalRecord medicalRecord) {
		this.medicalRecords.add(medicalRecord);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MedicalHistory that = (MedicalHistory) o;
		return id == that.id && patientId == that.patientId && Objects.equals(medicalRecords, that.medicalRecords);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, patientId, medicalRecords);
	}

	@Override
	public String toString() {
		return "MedicalHistory{" +
				"id=" + id +
				", currentHealthStatus='" + currentHealthStatus + '\'' +
				", allergies='" + allergies + '\'' +
				", patientId=" + patientId +
				", medicalRecords=" + medicalRecords +
				'}';
	}
}