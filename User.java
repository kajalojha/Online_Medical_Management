package Online_Medical_Management_System;

import static Online_Medical_Management_System.Online_Medical_Management_System.userManager;

public class User {
    private final String user_id;
    private String user_name ;
    private String user_email;
    private String user_password;
    public User (String user_id ,String user_name , String user_email ,String user_password) {
        this.user_id = user_id;
        this.user_name = user_name ;
        this.user_email = user_email ;
        this.user_password = user_password;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    public String toString(){
        return "User{"+
                "id ='" + user_id + '\''+
                "name ='"+ user_name + '\''+
                "email ='" + user_email + '\''+
                "password='" + user_password + '\''+
                '}';
    }

}
