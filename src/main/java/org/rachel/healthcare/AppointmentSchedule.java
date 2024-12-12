package org.rachel.healthcare;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppointmentSchedule {
	private final int id = IdGenerator.generateId();
	private final int healthcareCentreId;
	private final Map<Integer, Appointment> appointments = new HashMap<>();

	public AppointmentSchedule(int healthcareCentreId) {
		this.healthcareCentreId = healthcareCentreId;
	}

	public int getId() {
		return id;
	}

	public int getHealthcareCentreId() {
		return healthcareCentreId;
	}

	public Map<Integer, Appointment> getAppointments() {
		return appointments;
	}

	public void addAppointment(Appointment appointment) {
		this.appointments.put(appointment.getId(), appointment);
	}

	public void removeAppointment(Appointment appointment) {
		this.appointments.remove(appointment.getId());
	}

	public Appointment getAppointment(final int id) {
		return this.appointments.get(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppointmentSchedule that = (AppointmentSchedule) o;
		return id == that.id && healthcareCentreId == that.healthcareCentreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, healthcareCentreId);
	}

	@Override
	public String toString() {
		return "AppointmentSchedule{" +
				"id=" + id +
				", healthcareCentreId=" + healthcareCentreId +
				", appointments=" + appointments +
				'}';
	}
}