package Online_Medical_Management_System;


import java.util.ArrayList;
import java.util.List;

import static Online_Medical_Management_System.Online_Medical_Management_System.scanner;

public class User_Manager {
    List<User>userList;
    public User_Manager(){
        this.userList = new ArrayList<>();
    }
    public void registerUser()
    {
        System.out.println("Enter the id of user");
        String userId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter name of name ");
        String userName = scanner.nextLine();
        System.out.println("enter the email of user ");
        String userEmail = scanner.nextLine();
        System.out.println("enter password ");
        String password = scanner.nextLine();
        for(User user : userList){
            if(user.getUser_id().equals(userId )&& user.getUser_password().equals(password)){
                System.out.println("User already exist !!");
                return;
            }
        }
        User user = new User(userId,userName,userEmail,password);
        userList.add(user);
        System.out.println("User added successfully..");
        System.out.println(userList);
    }
    public User loginUser()
    {
        System.out.println("Enter the userId ");
        String userId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
       User userToFind = null;
        for(User user: userList)
        {
            if(user.getUser_id().equals(userId) && user.getUser_password().equals(password))
            {
                userToFind = user;
                break;
            }
        }
        if(userToFind!=null)
        {
            System.out.println("User is log in");
            return userToFind;
        }
        else
        {
            System.out.println("useer not found , register your self before login");
            return null;
        }
    }
    public void addUser() {
        System.out.println("Enter the user details:");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(User user : userList){
            if(user.getUser_id().equals(id)){
                System.out.println(" user already exists ");
                return;
            }
        }
        User user = new User(id , name , email , password)  ;
        userList.add(user);
        System.out.println(" user added successfully !!! ");
        System.out.println(userList);
    }
    public void deleteUser() {
        System.out.println("Enter the User details that you want to delete :");
        System.out.println("Enter the id:");
        String id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the password :");
        String password = scanner.nextLine();
        //check doctor already exist or not
        for(User user : userList){
            if(user.getUser_id().equals(id)){
                userList.remove(user);
                System.out.println(" user deleted  successfully  ");
                return;
            }
        }

        System.out.println("invalid information !!! ");

    }


}
