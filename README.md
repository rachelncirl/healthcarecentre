Health Care Appointment System

The Healthcare Appointment System is designed to manage the booking, modification and 
cancellation of medical appointments. It is intended to remove the manual and time-consuming
nature of managing the resources available to a healthcare facility. New HealthCareCentres
can be created, Appointments can be created, modified and removed, Doctors, Receptionists
and Patients can be added or moved.

Patient: Contains details specific to the Patient at the Healthcare centre. Attributes would be first 
name, last name, email address, phone number, registration date, date of birth, sex, and address 
id. The address id would link to a specific address in the Address class. The Address object is 
also associated to the staff members and the healthcare centre as it holds information that would 
be common across multiple objects and reduces repeating common information across multiple 
objects.

Address: Data object for storing addresses. Consists of house number, street, city, county, 
country, and postcode.

Contact Details: Will hold the contact number and email address for the associated entity.

Account: Will contain the patient idetifier and the balance on the account. Amounts can be
debited and credited from the Account

Medical History: Made up of multiple medical records, patient identifier, current medical status 
of the patient and know allergies.

Medical Record: Individual medical record of each appointment with the Healthcare centre. 
Contains an identifier to the complete medical history to which it belongs, and identifier to the 
doctor that carried out the appointment, the date of the appointment, the conditions and 
symptoms record during the appointment, and the medicine prescribed to the Patient.

Staff: Generalized superclass containing information common among different types of staff
such as Receptionists and Doctors. This will be an abstract class and extended by the specialized 
sub class instances.

Receptionist: Concrete specialization of the Staff class containing attributes specific to the 
Receptionist.

Doctor: Concrete specialization of the Staff class containing attributes specific to the Doctor.

Appointment: Contains details of the appointment. This will include the date the time of the 
appointment, the description of the ailments as reported by the patient, the patient identifier, the 
id of the staff member that made the appointment, and the identifier of the doctor who will carry 
out the appointment.

Healthcare Centre: Contains all information concerning the Healthcare Centre. It will have an 
association to the Appointment Schedule which will contain the details of all appointments 
carried out in the health centre, to the Patient Registry which contains the details of all patients 
currently registered with the Healthcare Centre, to the Staff Registry containing the details of all 
staff currently employed by the Healthcare Centre, and an address identifier linking the 
Healthcare Centre to an address.

Appointment Schedule: Object containing the appointment schedule for the Healthcare Centre.

Patient Registry: Object containing the patient registry for the Healthcare Centre.

Staff Registry: Object containing the staff registry for the Healthcare Centre.
