package Online_Medical_Management_System;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Online_Medical_Management_System {
    static Scanner scanner = new Scanner(System.in);
    static User userTologin = null;

    static Admin_Manager adminManager = new Admin_Manager();
    static User_Manager userManager = new User_Manager();
    static Doctor_Manager doctorManager = new Doctor_Manager();
    static Patient_Manager patientManager = new Patient_Manager();

    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            System.out.println("Select your role:");
            System.out.println("1. Admin");
            System.out.println("2. User ");
            System.out.println("3. Patient ");
            System.out.println("4. Doctor");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Do you want to register or login:");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1: {
                            adminManager.registerAdmin();
                            break;
                        }
                        case 2: {
                            if (adminManager.loginAdmin()) {
                                adminMenu();
                            } else {
                                System.out.println("Admin not found.");
                            }
                            break;
                        }
                        default:
                            System.out.println("Select a valid option.");
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Do you want to register or login:");
                    System.out.println("1. Register ");
                    System.out.println("2. Login ");
                    int option = scanner.nextInt();
                    switch (option) {
                        case 1: {
                            userManager.registerUser();
                            break;
                        }
                        case 2: {
                            userManager.loginUser();
                            userMenu();
                            break;
                        }
                        default:
                            System.out.println("Select a valid option.");
                            break;
                    }
                    break;
                }
                case 3:{
                    System.out.println("you want to register or login ");
                    System.out.println("1. register ");
                    System.out.println("2 login ");
                    int option = scanner.nextInt();
                    switch(option){
                        case 1:{
                            patientManager.registerPatient();
                            break;
                        }
                        case 2:{
                            patientManager.loginPatient();
                            patientMenu();
                            break;
                        }
                        default:{
                            System.out.println("select a valid optiion");
                            break;
                        }

                    }
                    break;

                }
                case 4:{
                    System.out.println("you want to register or login");
                    System.out.println("1. register ");
                    System.out.println("2. login ");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1:
                        {
                            doctorManager.registerDoctor();
                            break;
                        }
                        case 2:
                        {
                            doctorManager.logindoctor();
                            doctorMenu();
                            break;
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Select a valid role.");
                    break;
                }
            }
        }
    }

    // Admin menu
    public static void adminMenu() {
        while (true) {
            System.out.println("select an option ");
            System.out.println("Exit");
            System.out.println("1. add doctor");
            System.out.println("2. delete doctor ");
            System.out.println("3. add patient");
            System.out.println("4. delete patient ");
            System.out.println("5. add user ");
            System.out.println("6. delete user ");
            int choice = scanner.nextInt();
            if(choice == 0){
                return;
            }
            switch (choice){
                case 1:
                {
                    doctorManager.addDoctor();
                    break;
                }
                case 2:
                {
                    doctorManager.deleteDoctor();
                    break;
                }
                case 3:
                {
                    patientManager.addPatient();
                    break;
                }
                case 4:
                {
                    patientManager.deletePatient();
                    break;
                }
                case 5:
                {
                    userManager.addUser();
                    break;
                }
                case 6:
                {
                    userManager.deleteUser();
                    break;
                }
                default:{
                    System.out.println("make a valid choice ");
                    break;
                }
            }
        }
    }

    // user menu
    public static void userMenu() {
        System.out.println(" select an option ");
        System.out.println("0. Exit");
        // Add code for user menu here
    }
    // patient menu
    public static void patientMenu(){
        System.out.println("select an option ");
        System.out.println("0. exit ");
        System.out.println("1. schedule appointment ");
        int choice = scanner.nextInt();
        if(choice == 0 ){
            return;
        }
        switch(choice){//2021-12-12 15:30
            case 1:{
                adminManager.scheduleAppointment();
                break;
            }
        }
    }
    public static void doctorMenu(){
        System.out.println("select an option ");
        System.out.println("0. exit ");

    }
}
