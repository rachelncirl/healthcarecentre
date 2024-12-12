package org.rachel.healthcare;

import java.time.LocalDateTime;
import java.util.Objects;

public class MedicalRecord {
	private final int id = IdGenerator.generateId();
	private final LocalDateTime date;
	private String condition;
	private String perscription;
	private String symptoms;
	private final int medicalHistoryId;
	private final int doctorId;

	public MedicalRecord(final LocalDateTime date, final String condition, final String perscription, final String symptoms, final int medicalHistoryId, final int doctorId) {
		this.date = date;
		this.condition = condition;
		this.perscription = perscription;
		this.symptoms = symptoms;
		this.medicalHistoryId = medicalHistoryId;
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPerscription() {
		return perscription;
	}

	public void setPerscription(String perscription) {
		this.perscription = perscription;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public int getMedicalHistoryId() {
		return medicalHistoryId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MedicalRecord that = (MedicalRecord) o;
		return id == that.id && medicalHistoryId == that.medicalHistoryId && doctorId == that.doctorId && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, medicalHistoryId, doctorId);
	}

	@Override
	public String toString() {
		return "MedicalRecord{" +
				"id=" + id +
				", date=" + date +
				", condition='" + condition + '\'' +
				", perscription='" + perscription + '\'' +
				", symptoms='" + symptoms + '\'' +
				", medicalHistoryId=" + medicalHistoryId +
				", doctorId=" + doctorId +
				'}';
	}
}