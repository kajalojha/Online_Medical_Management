package Online_Medical_Management_System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static Online_Medical_Management_System.Online_Medical_Management_System.doctorManager;
import static Online_Medical_Management_System.Online_Medical_Management_System.scanner;

public class Doctor_Manager {
     public List<Doctor>doctorList;
    public Doctor_Manager(){
        this.doctorList = new ArrayList<>();
    }
    public void registerDoctor()
    {
        System.out.println("Enter the id ");
        String Id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter name  ");
        String Name = scanner.nextLine();
        System.out.println("enter the email");
        String Email = scanner.nextLine();
        System.out.println("enter specialist");
        String specialist = scanner.nextLine();
        System.out.println("enter appointments ");
        String appointment = scanner.nextLine();
        System.out.println("enter password ");
        String password = scanner.nextLine();
        for(Doctor doctor : doctorList){
            if(doctor.getDoc_id().equals(Id )&& doctor.getDoc_password().equals(password)){
                System.out.println("Doctor already exist !!");
                return;
            }
        }
        Doctor doctor = new Doctor(Id,Name,Email,password,specialist , appointment);
        doctorList.add(doctor);
        System.out.println("Doctor added successfully..");
        System.out.println(doctorList);
    }
    public Doctor logindoctor()
    {
        System.out.println("Enter the Id ");
        String Id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        Doctor doctorToFind = null;
        for(Doctor doctor: doctorList)
        {
            if(doctor.getDoc_id().equals(Id) && doctor.getDoc_password().equals(password))
            {
                doctorToFind = doctor;
                break;
            }
        }
        if(doctorToFind!=null)
        {
            System.out.println("doctor is log in");
            return doctorToFind;
        }
        else
        {
            System.out.println(" not found , register your self before login");
            return null;
        }
    }
    public void addDoctor() {
        System.out.println("Enter the doctor details:");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the specialist:");
        String specialist = scanner.nextLine();
        System.out.println("Enter the appointments:");
        String appointments = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(Doctor doctor : doctorList){
            if(doctor.getDoc_id().equals(id)){
                System.out.println("doctor already exists ");
                return;
            }
        }
        Doctor doctor = new Doctor(id , name , email ,specialist , appointments , password)  ;
        doctorList.add(doctor);
        System.out.println("doctor added successfully !!! ");
        System.out.println(doctorList);
    }
    public void deleteDoctor() {
        System.out.println("Enter the doctor details that you want to delete :");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password :");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(Doctor doctor : doctorList){
            if(doctor.getDoc_id().equals(id)){
                doctorList.remove(doctor);
                System.out.println("doctor deleted  successfully  ");
                return;
            }
        }

        System.out.println("invalid information !!! ");

    }
//    public void addAppointment(Appointment appointment){
//        for(Appointment appointment2 : appointment.appointmentList){
//            appointment.appointmentList.add(appointment2);
//        }
//
//    }
public void addAppointmentDoctor( Doctor doctor ,Appointment appointment){
    for(Appointment appointment1 : appointment.appointmentList){
        appointment.appointmentList.add(appointment1);
    }

    appointment.appointmentList.add(appointment);

}



}




