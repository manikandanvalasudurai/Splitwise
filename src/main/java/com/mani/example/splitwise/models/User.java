package com.mani.example.splitwise.models;
import jakarta.persistence.Entity;

@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String Password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


