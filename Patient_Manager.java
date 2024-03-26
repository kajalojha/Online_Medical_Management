package Online_Medical_Management_System;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static Online_Medical_Management_System.Online_Medical_Management_System.doctorManager;
import static Online_Medical_Management_System.Online_Medical_Management_System.scanner;

public class Patient_Manager {
    List<Patient> patientList;
    Patient_Manager(){
        this.patientList = new ArrayList<>();
    }
    public void registerPatient()
    {
        System.out.println("Enter the id ");
        String Id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter name  ");
        String Name = scanner.nextLine();
        System.out.println("enter the email");
        String Email = scanner.nextLine();
        System.out.println("enter appointments ");
        String appointment = scanner.nextLine();
        System.out.println("enter password ");
        String password = scanner.nextLine();
        for(Patient patient : patientList){
            if(patient.getPatient_id().equals(Id )&& patient.getPatient_password().equals(password)){
                System.out.println("Patient already exist !!");
                return;
            }
        }
        Patient patient = new Patient(Id,Name,Email,password, appointment);
       patientList.add(patient);
        System.out.println("patient added successfully..");
        System.out.println(patientList);
    }
    public Patient loginPatient()
    {
        System.out.println("Enter the Id ");
        String Id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
       Patient patientToFind = null;
        for(Patient patient: patientList)
        {
            if(patient.getPatient_id().equals(Id) && patient.getPatient_password().equals(password))
            {
                patientToFind = patient;
                break;
            }
        }
        if(patientToFind!=null)
        {
            System.out.println("patient log in successfully!! ");
            return patientToFind;
        }
        else
        {
            System.out.println(" not found , register your self before login");
            return null;
        }
    }
    public void addPatient() {
        System.out.println("Enter the patient details:");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the appointments:");
        String appointments = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(Patient patient : patientList){
            if(patient.getPatient_id().equals(id)){
                System.out.println(" patient already exists ");
                return;
            }
        }
        Patient patient = new Patient(id , name , email ,appointments , password)  ;
        patientList.add(patient);
        System.out.println("patient  added successfully !!! ");
        System.out.println(patientList);
    }
    public void deletePatient() {
        System.out.println("Enter the Patient details that you want to delete :");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password :");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(Patient patient : patientList){
            if(patient.getPatient_id().equals(id)){
                patientList.remove(patient);
                System.out.println("patient deleted  successfully  ");
                return;
            }
        }

        System.out.println("invalid information !!! ");
    }
    public void addAppointmentToPatient( Patient patient ,Appointment appointment){
        for(Appointment appointment1 : appointment.appointmentList){
            appointment.appointmentList.add(appointment1);
        }

        appointment.appointmentList.add(appointment);

    }

    public void scheduleAppointment(){
        System.out.println("Enter the details to schedule appointment :");
        System.out.println("Enter the patient id ");
        String patientId = scanner.nextLine();
        scanner.nextLine(); // Remove extra nextLine() call
        System.out.println("Enter the patient name :");
        String patientName = scanner.nextLine();
        System.out.println("Enter the disease :");
        String disease = scanner.nextLine();
        System.out.println("Enter the doctor id ");
        String doctorId = scanner.nextLine();
        System.out.println("Enter the doctor name :");
        String doctorName = scanner.nextLine();
        System.out.println("Enter the date and time to schedule appointment (YYYY-MM-DD HH:MM):");
        String dateTimeString = scanner.nextLine();

        LocalDateTime dateTime = null;
        try {
            // Parse the input string into a LocalDateTime object using DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dateTime = LocalDateTime.parse(dateTimeString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date and time format. Please use the format: YYYY-MM-DD HH:MM");
            return;
        }

        Patient patient = findPatientByid(patientId);
        Doctor doctor = findDoctorByid(doctorId);

        if(patient != null && doctor != null) {
            Appointment appointment = new Appointment(patientId, doctorId, dateTime);
            doctor.addAppointment(appointment);
            patient.addAppointment(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Patient or doctor not found. Please ensure both exist before scheduling an appointment.");
        }
    }

    public  Patient findPatientByid(String patientId){
     for(Patient patient : patientList){
         if(patient.getPatient_id().equals(patientId)){
             return patient;
         }
     }
     return null;
    }
    public  Doctor findDoctorByid(String Doc_id){
        for(Doctor doctor : doctorManager.doctorList){
            if(doctor.getDoc_id().equals(Doc_id)){
                return doctor;
            }
        }
        return null;
    }
//    Doctor findDoctorByid(String doc_id){
//        for(Doctor doctor : doctorManager.doctorList){
//            if(doctor.getDoc_id().equals(doc_id)){
//                return doctor;
//            }
//        }
//        return null;
//    }



}
