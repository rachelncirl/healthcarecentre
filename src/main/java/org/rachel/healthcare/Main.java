package org.rachel.healthcare;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        new Main().populate();
    }

    private void populate() {

        // Create a new Health Care centre
        ContactDetails swordsContactDetails = new ContactDetails("swords@health.ie", "016908754");

        Address swordsAddress = new Address("24 Airside Business Park", "Swords", "Dublin", "K67WK98");

        HealthcareCentre healthcareCentre = new HealthcareCentre("Swords", swordsAddress, swordsContactDetails);

        Patient rachel = new Patient("Rachel", "Roche", LocalDate.of(1986, 5, 25),
                "Female", swordsAddress, swordsContactDetails, healthcareCentre.getPatientRegistry().getId(), healthcareCentre.getId());
        healthcareCentre.getPatientRegistry().addPatient(rachel);

        System.out.println(healthcareCentre.toString());
        System.out.println(rachel.toString());

        Doctor doctor = new Doctor("John", "Doe", swordsAddress, swordsContactDetails, healthcareCentre.getStaffRegistry().getId(), "General");
        healthcareCentre.getStaffRegistry().addDoctor(doctor);

        Receptionist receptionist = new Receptionist("Jane", "Doe", swordsAddress, swordsContactDetails, healthcareCentre.getStaffRegistry().getId());
        healthcareCentre.getStaffRegistry().addReceptionist(receptionist);

        MedicalRecord medicalRecord = new MedicalRecord(LocalDateTime.now(), "Covid", "N/A", "Headache", rachel.getMedicalHistory().getId(), doctor.getId());

        rachel.getMedicalHistory().addMedicalRecord(medicalRecord);
        System.out.println(rachel.getMedicalHistory().toString());

        Appointment appointment = new Appointment("Check Up", LocalDateTime.now(), rachel.getId(), receptionist.getReceptionistID(), doctor.getDoctorId(), healthcareCentre.getAppointmentSchedule().getId());
        healthcareCentre.getAppointmentSchedule().addAppointment(appointment);

        System.out.println(healthcareCentre.getAppointmentSchedule());

    }
}