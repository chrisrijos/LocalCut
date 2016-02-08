package com.example.rijos.localcut.models;

/**
 * User Model contains preliminary test user data required for account creation.
 */
public class User{


    private int birthyear;
    private String fullname;
    private String email;
    private String password;
    private Boolean isBarber = false;

    public User(){}

    /*Database insertion test*/
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
