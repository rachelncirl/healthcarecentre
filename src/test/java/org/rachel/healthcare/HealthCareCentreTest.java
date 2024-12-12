package org.rachel.healthcare;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test class to verify that health care centre is functional.
 *
 * @author Rachel Roche
 */
public class HealthCareCentreTest {

    private HealthcareCentre healthcareCentre;

    @Before
    public void setUp() {

        // Create contact details for the patient, doctor and receiptionist
        ContactDetails rachelContactDetails = new ContactDetails("rachel@live.ie", "0871234567");
        ContactDetails receptionistContactDetails = new ContactDetails("doctor@health.ie", "016908754");
        ContactDetails doctorContactDetails = new ContactDetails("receptionist@health.ie", "016908754");

        // Create addresses for the patient, doctor and receiptionist
        Address rachelAddress = new Address("2A Forest Way", "Swords", "Dublin", "K67WK11");
        Address receptionistAddress = new Address("37 Airport Road", "Santry", "Dublin", "K72LY49");
        Address doctorAddress = new Address("1 Marina Bay", "Malahide", "Dublin", "K87TR57");

        // Create a new Health Care centre
        ContactDetails swordsContactDetails = new ContactDetails("swords@health.ie", "016908754");
        Address swordsAddress = new Address("24 Airside Business Park", "Swords", "Dublin", "K67WK98");
        healthcareCentre = new HealthcareCentre("Swords", swordsAddress, swordsContactDetails);

        // Add a doctor to the health care centre
        Doctor doctor = new Doctor("John", "Doe", doctorAddress, doctorContactDetails, healthcareCentre.getStaffRegistry().getId(), "General");
        healthcareCentre.getStaffRegistry().addDoctor(doctor);

        // Add a receptionist to the health care centre
        Receptionist receptionist = new Receptionist("Jane", "Doe", receptionistAddress, receptionistContactDetails, healthcareCentre.getStaffRegistry().getId());
        healthcareCentre.getStaffRegistry().addReceptionist(receptionist);

        // Add a Patient to the Health Care centre
        Patient rachel = new Patient("Rachel", "Roche", LocalDate.of(1986, 5, 25), "Female", rachelAddress, rachelContactDetails, healthcareCentre.getPatientRegistry().getId(), healthcareCentre.getId());
        healthcareCentre.getPatientRegistry().addPatient(rachel);

        // Add a Medical Record to the patient
        MedicalRecord medicalRecord = new MedicalRecord(LocalDateTime.now(), "Covid", "N/A", "Headache", rachel.getMedicalHistory().getId(), doctor.getId());
        rachel.getMedicalHistory().addMedicalRecord(medicalRecord);

        // Add an appointment
        Appointment appointment = new Appointment("Check Up", LocalDateTime.now(), rachel.getId(), receptionist.getReceptionistID(), doctor.getDoctorId(), healthcareCentre.getAppointmentSchedule().getId());
        healthcareCentre.getAppointmentSchedule().addAppointment(appointment);

    }

    /**
     * Test section verifying the creation of the objects and that values can be retrieved correctly from the objects.
     */

    @Test
    public void verify_contact_details_creation() {

        ContactDetails contactDetails = new ContactDetails("jon@johnson.com", "0865478965");

        assertEquals(contactDetails.getEmailAddress(), "jon@johnson.com");
        assertEquals(contactDetails.getPhoneNumber(), "0865478965");
    }

    @Test
    public void verify_address_creation() {

        Address address = new Address("1 Shop Street", "Galway", "Galway", "G12HF45");

        assertEquals(address.getStreet(), "1 Shop Street");
        assertEquals(address.getCity(), "Galway");
        assertEquals(address.getCounty(), "Galway");
        assertEquals(address.getPostalCode(), "G12HF45");

    }

    @Test
    public void verify_account_creation() {

        Account account = new Account(100, 2001, 1);

        assertEquals(account.getBalance(), 100);
        assertEquals(account.getPatientId(), 2001);
        assertEquals(account.getHealthcareCentreId(), 1);
    }

    @Test
    public void verify_id_generaton() {

        int id = IdGenerator.generateId();
        int nextId = IdGenerator.generateId();

        assertNotEquals(id, 0);
        assertNotEquals(nextId, 0);
        assertEquals(id, nextId - 1);
    }

    @Test
    public void verify_patient_creation() {

        Address address = new Address("1 Shop Street", "Galway", "Galway", "G12HF45");
        ContactDetails contactDetails = new ContactDetails("jon@johnson.com", "0865478965");
        Patient patient = new Patient("James", "Black", LocalDate.of(1988, 2, 14), "Male", address, contactDetails, 1, 24);

        assertEquals(patient.getFirstName(), "James");
        assertEquals(patient.getLastName(), "Black");
        assertEquals(patient.getContactDetails(), contactDetails);
        assertEquals(patient.getAddress(), address);
        assertEquals(patient.getPatientRegistryId(), 1);
        assertEquals(patient.getAccount().getHealthcareCentreId(),24);

    }

    @Test
    public void verify_doctor_creation() {

        Address address = new Address("1 Shop Street", "Galway", "Galway", "G12HF45");
        ContactDetails contactDetails = new ContactDetails("jon@johnson.com", "0865478965");
        Doctor doctor = new Doctor("Jack", "Doe", address, contactDetails, 1001, "General");

        assertEquals(doctor.getFirstName(), "Jack");
        assertEquals(doctor.getLastName(), "Doe");
        assertEquals(doctor.getContactDetails(), contactDetails);
        assertEquals(doctor.getAddress(), address);
        assertEquals(doctor.getStaffRegistryId(), 1001);
        assertEquals(doctor.getAreaOfExperiese(), "General");

    }

    @Test
    public void verify_receptionist_creation() {

        Address address = new Address("1 Shop Street", "Galway", "Galway", "G12HF45");
        ContactDetails contactDetails = new ContactDetails("jon@johnson.com", "0865478965");
        Receptionist receptionist = new Receptionist("Sheila", "White", address, contactDetails, 40);

        assertEquals(receptionist.getFirstName(), "Sheila");
        assertEquals(receptionist.getLastName(), "White");
        assertEquals(receptionist.getContactDetails(), contactDetails);
        assertEquals(receptionist.getAddress(), address);
        assertEquals(receptionist.getStaffRegistryId(), 40);
    }

    @Test
    public void verify_medical_history_creation() {

        MedicalHistory medicalHistory = new MedicalHistory(15);

        assertEquals(medicalHistory.getPatientId(), 15);
        assertEquals(medicalHistory.getCurrentHealthStatus(), "N/A");
        assertEquals(medicalHistory.getAllergies(), "N/A");
        assertTrue(medicalHistory.getMedicalRecords().isEmpty());

    }

    @Test
    public void verify_medical_record_creation() {

        LocalDateTime date = LocalDateTime.now();
        MedicalRecord medicalRecord = new MedicalRecord(date, "Chest Pain", "Painkillers", "Constant Pain", 45, 2);

        assertEquals(medicalRecord.getDate(), date);
        assertEquals(medicalRecord.getCondition(), "Chest Pain");
        assertEquals(medicalRecord.getPerscription(), "Painkillers");
        assertEquals(medicalRecord.getSymptoms(), "Constant Pain");
        assertEquals(medicalRecord.getMedicalHistoryId(), 45);
        assertEquals(medicalRecord.getDoctorId(), 2);
    }

    @Test
    public void verify_appointment_creation() {

        LocalDateTime appointmentDate = LocalDateTime.now();
        Appointment appointment = new Appointment("Check Up", appointmentDate, 55, 23, 7, 65);

        assertEquals(appointment.getDescription(), "Check Up");
        assertEquals(appointment.getAppointmentDate(), appointmentDate);
        assertEquals(appointment.getPatientId(), 55);
        assertEquals(appointment.getReceptionistId(), 23);
        assertEquals(appointment.getDoctorId(), 7);
        assertEquals(appointment.getAppointmentScheduleId(), 65);

    }

    @Test
    public void verify_appointment_schedule_creation() {

        AppointmentSchedule appointmentSchedule = new AppointmentSchedule(1);

        assertEquals(appointmentSchedule.getHealthcareCentreId(), 1);
        assertTrue(appointmentSchedule.getAppointments().isEmpty());

    }

    @Test
    public void verify_patient_register_creation() {

        PatientRegistry patientRegistry = new PatientRegistry(1);

        assertEquals(patientRegistry.getHealthcareCentreId(), 1);
        assertTrue(patientRegistry.getPatients().isEmpty());
    }

    @Test
    public void verify_staff_register_creation() {

        StaffRegistry staffRegistry = new StaffRegistry(1);

        assertEquals(staffRegistry.getHealthcareCentreId(), 1);
        assertTrue(staffRegistry.getDoctors().isEmpty());
        assertTrue(staffRegistry.getReceptionists().isEmpty());

    }

    @Test
    public void verify_healthcarecentre_creation() {

        ContactDetails contactDetails = new ContactDetails("belfast@health.ie", "00440816908754");
        Address address = new Address("24 Falls Road", "Belfast", "Antrim", "BT348UJ");
        HealthcareCentre healthcareCentre = new HealthcareCentre("Belfast", address, contactDetails);

        // Assert the new health care centre is create and all registries are empty
        assertEquals(contactDetails, healthcareCentre.getContactDetails());
        assertEquals(address, healthcareCentre.getAddress());
        assertTrue(healthcareCentre.getAppointmentSchedule().getAppointments().isEmpty());
        assertTrue(healthcareCentre.getStaffRegistry().getDoctors().isEmpty());
        assertTrue(healthcareCentre.getStaffRegistry().getReceptionists().isEmpty());
        assertTrue(healthcareCentre.getPatientRegistry().getPatients().isEmpty());

    }

    /**
     * Tests to validate the correct behaviour between objects during general use cases.
     */

    @Test
    public void add_patient_to_healthcarecentre() {

        // Add a Patient to the Health Care centre
        Address address = new Address("4 The Paddocks", "Ardee", "Louth", "L87TF54");
        ContactDetails contactDetails = new ContactDetails("jon@johnson.com", "0865478965");
        Patient patient = new Patient("John", "Johnson", LocalDate.of(1978, 7, 14),
                "Male", address, contactDetails, healthcareCentre.getPatientRegistry().getId(), healthcareCentre.getId());
        healthcareCentre.getPatientRegistry().addPatient(patient);

        // verify the patient has been added to the health care centre
        assertEquals(healthcareCentre.getPatientRegistry().getPatient(patient.getId()), patient);
        assertEquals(healthcareCentre.getPatientRegistry().getPatients().size(), 2);
        assertTrue(healthcareCentre.getPatientRegistry().getPatient(patient.getId()).getMedicalHistory().getMedicalRecords().isEmpty());

    }

    @Test
    public void update_patient_address() {

        // Create a new address
        Address address = new Address("Crinny West", "Castleisland", "Kerry", "V92H9K2");

        // Get the patient to update
        Patient patient = healthcareCentre.getPatientRegistry().getPatients().values().iterator().next();
        patient.setAddress(address);

        // Assert that the patient's address has been updated in the registry
        assertEquals(healthcareCentre.getPatientRegistry().getPatient(patient.getId()).getAddress(), address);
    }

    @Test
    public void update_balance_on_patient_account() {

        // Get the patient to update
        Patient patient = healthcareCentre.getPatientRegistry().getPatients().values().iterator().next();

        // Patient is charged 100 euro
        patient.getAccount().charge(100);

        // Patient pays 60 euro off their account
        patient.getAccount().pay(60);

        // Assert that the patient's account balance is now 40 euro
        assertEquals(healthcareCentre.getPatientRegistry().getPatient(patient.getId()).getAccount().getBalance(), 40);
    }

    @Test
    public void update_health_care_centre_contact_details() {

        // Create the new contact details
        ContactDetails swordsHealthCentreContactDetails = new ContactDetails("info@health.ie", "1800999999");

        // Set the new contact details for the health centre
        healthcareCentre.setContactDetails(swordsHealthCentreContactDetails);

        // Verify the health care centre has been updated with the new contact details
        assertEquals(healthcareCentre.getContactDetails(), swordsHealthCentreContactDetails);

    }

    @Test
    public void add_doctor() {

        // Add a doctor to the health care centre
        ContactDetails contactDetails = new ContactDetails("tom@health.ie", "0859658745");
        Address address = new Address("27 Main Street", "Castlebellingham", "Louth", "L34J4U7");
        Doctor doctor = new Doctor("Tom", "Jones", address, contactDetails, healthcareCentre.getStaffRegistry().getId(), "Children");
        healthcareCentre.getStaffRegistry().addDoctor(doctor);

        assertEquals(healthcareCentre.getStaffRegistry().getDoctor(doctor.getId()), doctor);
        assertEquals(healthcareCentre.getStaffRegistry().getDoctor(doctor.getId()).getAddress(), address);
        assertEquals(healthcareCentre.getStaffRegistry().getDoctor(doctor.getId()).getContactDetails(), contactDetails);
        assertEquals(healthcareCentre.getStaffRegistry().getDoctors().size(), 2);
    }

    @Test
    public void add_receptionist() {

        // Add a receptionist to the health care centre
        ContactDetails contactDetails = new ContactDetails("mary@health.ie","0835987125");
        Address address = new Address("Kilconlea Upper", "Abbeyfeale", "Limerick", "V94E09D");
        Receptionist receptionist = new Receptionist("Mary", "Lane", address, contactDetails, healthcareCentre.getStaffRegistry().getId());
        healthcareCentre.getStaffRegistry().addReceptionist(receptionist);

        assertEquals(healthcareCentre.getStaffRegistry().getReceptionist(receptionist.getId()), receptionist);
        assertEquals(healthcareCentre.getStaffRegistry().getReceptionist(receptionist.getId()).getAddress(), address);
        assertEquals(healthcareCentre.getStaffRegistry().getReceptionist(receptionist.getId()).getContactDetails(), contactDetails);
        assertEquals(healthcareCentre.getStaffRegistry().getReceptionists().size(), 2);
    }

    @Test
    public void add_appointment() {

        // Get the ids of the patient, doctor and receptionist for the appointment
        Patient patient = healthcareCentre.getPatientRegistry().getPatients().values().iterator().next();
        Doctor doctor = healthcareCentre.getStaffRegistry().getDoctors().values().iterator().next();
        Receptionist receptionist = healthcareCentre.getStaffRegistry().getReceptionists().values().iterator().next();

        // Add the appointment to the schedule of the health care centre
        Appointment appointment = new Appointment("Check Up", LocalDateTime.now(), patient.getId(), receptionist.getId(), doctor.getId(), healthcareCentre.getAppointmentSchedule().getId());
        healthcareCentre.getAppointmentSchedule().addAppointment(appointment);

        // Verify the appointment has been added to the schedule
        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointment(appointment.getId()), appointment);
        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointments().size(), 2);

    }

    @Test
    public void modify_appointment() {

        // Create the details to update
        LocalDateTime updatedAppointmentDate = LocalDateTime.of(2025, 8, 15, 10, 45);
        String updatedDescription = "Rescheduled Check Up to August 2025";

        // Update the appointment
        Appointment appointment = healthcareCentre.getAppointmentSchedule().getAppointments().values().iterator().next();
        appointment.setAppointmentDate(updatedAppointmentDate);
        appointment.setDescription(updatedDescription);

        // Verify the appointment is updated in the appointment schedule
        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointment(appointment.getId()).getAppointmentDate(), updatedAppointmentDate);
        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointment(appointment.getId()).getDescription(), updatedDescription);
    }

    @Test
    public void remove_appointment() {

        // Get the total number of appointments stored in the health care centre
        int numberOfAppointments = healthcareCentre.getAppointmentSchedule().getAppointments().size();

        // Get an appointment from the appointment schedule
        Appointment appointment = healthcareCentre.getAppointmentSchedule().getAppointments().values().iterator().next();

        // Remove the appointment
        healthcareCentre.getAppointmentSchedule().removeAppointment(appointment);

        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointment(appointment.getId()), null);
        assertEquals(healthcareCentre.getAppointmentSchedule().getAppointments().size(), numberOfAppointments - 1);

    }

    @Test
    public void add_another_healthcare_center() {

        // Create a new Health Care centre
        ContactDetails corkContactDetails = new ContactDetails("cork@health.ie", "0216908754");
        Address cork = new Address("76 Blackpool Place", "Cork", "Cork", "C34U7Y6");
        HealthcareCentre healthcareCentre = new HealthcareCentre("Swords", cork, corkContactDetails);

        // Assert the new health care centre is create and all registries are empty
        assertEquals(corkContactDetails, healthcareCentre.getContactDetails());
        assertEquals(cork, healthcareCentre.getAddress());
        assertTrue(healthcareCentre.getAppointmentSchedule().getAppointments().isEmpty());
        assertTrue(healthcareCentre.getStaffRegistry().getDoctors().isEmpty());
        assertTrue(healthcareCentre.getStaffRegistry().getReceptionists().isEmpty());
        assertTrue(healthcareCentre.getPatientRegistry().getPatients().isEmpty());

    }

    @Test
    public void move_doctor_from_one_healthcare_center_to_another() {

        // Create a new Health Care centre
        ContactDetails corkContactDetails = new ContactDetails("cork@health.ie", "0216908754");
        Address cork = new Address("76 Blackpool Place", "Cork", "Cork", "C34U7Y6");
        HealthcareCentre corkHealthcareCentre = new HealthcareCentre("Swords", cork, corkContactDetails);

        // Get a doctor from the existing health care centre
        Doctor doctor = healthcareCentre.getStaffRegistry().getDoctors().values().iterator().next();
        int numberOfDoctors = healthcareCentre.getStaffRegistry().getDoctors().size();

        // Remove the doctor from the existing health care centre
        healthcareCentre.getStaffRegistry().removeDoctor(doctor);

        // Ensure the doctor has been removed
        assertEquals(healthcareCentre.getStaffRegistry().getDoctor(doctor.getId()), null);
        assertEquals(healthcareCentre.getStaffRegistry().getDoctors().size(), numberOfDoctors - 1);

        // Update the healthcare centre id for the doctor to the new centre
        doctor.setStaffRegistryId(corkHealthcareCentre.getStaffRegistry().getId());

        // Add the doctor to the new health care centre
        corkHealthcareCentre.getStaffRegistry().addDoctor(doctor);

        // Verify the doctor has been added to the new health care centre
        assertEquals(corkHealthcareCentre.getStaffRegistry().getDoctors().size(), 1);
        assertEquals(corkHealthcareCentre.getStaffRegistry().getDoctor(doctor.getId()), doctor);

    }

}