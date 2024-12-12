package org.rachel.healthcare;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
	private final int id = IdGenerator.generateId();
	private String description;
	private LocalDateTime appointmentDate;
	private final int patientId;
	private final int receptionistId;
	private int doctorId;
	private final int appointmentScheduleId;

	public Appointment(String description, LocalDateTime appointmentDate, int patientId, int receptionistId, int doctorId, int appointmentScheduleId) {
		this.description = description;
		this.appointmentDate = appointmentDate;
		this.patientId = patientId;
		this.receptionistId = receptionistId;
		this.doctorId = doctorId;
		this.appointmentScheduleId = appointmentScheduleId;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getReceptionistId() {
		return receptionistId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getAppointmentScheduleId() {
		return appointmentScheduleId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Appointment that = (Appointment) o;
		return id == that.id && patientId == that.patientId && receptionistId == that.receptionistId && Objects.equals(appointmentDate, that.appointmentDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, appointmentDate, patientId, receptionistId);
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", description='" + description + '\'' +
				", appointmentDate=" + appointmentDate +
				", patientId=" + patientId +
				", receptionistId=" + receptionistId +
				", doctorId=" + doctorId +
				", appointmentScheduleId=" + appointmentScheduleId +
				'}';
	}
}