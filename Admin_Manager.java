package Online_Medical_Management_System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Online_Medical_Management_System.Online_Medical_Management_System.doctorManager;
import static Online_Medical_Management_System.Online_Medical_Management_System.scanner;


public class Admin_Manager {
    Admin admin = new Admin("101" , "kajal","kajal@gmail.com ", "1529");
    List<Admin> adminList ;
    List<Appointment>pendingAppointmentlist ;
    List<Appointment>confirmAppointmentlist ;

    Admin_Manager(){
        adminList = new ArrayList<>();
        pendingAppointmentlist = new ArrayList<>();
        confirmAppointmentlist = new ArrayList<>();
    }
    public void scheduleAppointment() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient details to schedule appointment:");
        System.out.println("Enter patient ID:");
        String patientId = scanner.nextLine();
        System.out.println("Enter doctor ID:");
        String doctorId = scanner.nextLine();
        System.out.println("Enter appointment date and time (YYYY-MM-DD HH:MM):");
        String dateTimeString = scanner.nextLine();

        // Parse date and time string into LocalDateTime object
        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Check if doctor is available at the specified date and time
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null && isDoctorAvailable(doctor, appointmentDateTime)) {
            // Create appointment and add to pending list
            Appointment appointment = new Appointment(patientId, doctorId, appointmentDateTime);
            pendingAppointmentlist.add(appointment);
            System.out.println("Appointment added to pending list.");
        } else {
            System.out.println("Doctor is not available at the specified date and time.");
        }
    }

    // Method to find doctor by ID
    private Doctor findDoctorById(String doctorId) {
        for (Doctor doctor : doctorManager.doctorList) {
            if (doctor.getDoc_id().equals(doctorId)) {
                return doctor;
            }
        }
        return null; // Doctor not found
    }

    public void registerAdmin()
    {
        System.out.println("Enter the id of admin");
        String adminId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter name of admin ");
        String adminName = scanner.nextLine();
        System.out.println("enter the email of admin ");
        String adminEmail = scanner.nextLine();
        System.out.println("enter password ");
        String password = scanner.nextLine();
        for(Admin admin : adminList){
            if(admin.getAdmin_id().equals(adminId )&& admin.getAdmin_password().equals(password)){
                System.out.println("Admin already exist !!");
                return;
            }
        }
        Admin admin = new Admin(adminId , adminName ,adminEmail,password);
        adminList.add(admin);
        System.out.println("Admin added successfully..");
        System.out.println(adminList);
    }
//    public boolean loginAdmin(){
//        System.out.println("enter admin id ");
//        String id = scanner.nextLine();
//        scanner.nextLine();
//        System.out.println("enter password ");
//        String pass = scanner.nextLine();
//        if(id.equals(admin.getAdmin_id()) && pass.equals(admin.getAdmin_password())){
//            System.out.println("admin added successfully ..");
//            return true;
//        }
//        else{
//            System.out.println("admin does not exist,please register your sels first...");
//            return false;
//        }
//    }
public boolean isDoctorAvailable(Doctor doctor, LocalDateTime dateTime) {
    // Get the doctor's appointments
    List<Appointment> appointments = doctor.getAppointments();

    // Check each appointment to see if it conflicts with the specified date and time
    for (Appointment appointment : appointments) {
        LocalDateTime appointmentDateTime = appointment.getDateTime();
        // Check if the appointment overlaps with the specified date and time
        if (appointmentDateTime.equals(dateTime) || appointmentDateTime.minusMinutes(30).isBefore(dateTime)
                && appointmentDateTime.plusMinutes(30).isAfter(dateTime)) {
            // Doctor is not available due to a conflicting appointment
            return false;
        }
    }

    // Doctor is available at the specified date and time
    return true;
}
    public List<Appointment> getAppointments(String doctorId) {
        Doctor doctor = findDoctorByid(doctorId);
        if (doctor != null) {
            return doctor.getAppointments();
        } else {
            System.out.println("Doctor not found.");
            return new ArrayList<>(); // Return an empty list if doctor is not found
        }
    }
    Doctor findDoctorByid(String doctor_id){
        for(Doctor doctor : doctorManager.doctorList){
            if(doctor.getDoc_id().equals(doctor_id)){
                return doctor;
            }
        }
        return null;
    }
public boolean loginAdmin() {
    System.out.println("Enter admin id:");
    String id = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter password:");
    String password = scanner.nextLine();

    // Loop through the admin list to find a matching admin
    for (Admin admin : adminList) {
        if (admin.getAdmin_id().equals(id) && admin.getAdmin_password().equals(password)) {
            System.out.println("Admin logged in successfully.");
            return true; // Admin found, return true
        }
    }

    System.out.println("Admin does not exist. Please register yourself first.");
    return false; // Admin not found, return false
}




}
