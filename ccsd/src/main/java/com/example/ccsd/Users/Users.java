// users.java
package com.example.ccsd.Users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;

@Document(collection = "user")
public class Users {

    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String role;
    private String username;
    private String dob;
    private byte[] profPic;

    public Users() {

    }

    public Users(byte[] profPic, String dob, String username, String role, String address, String phoneNumber, String lastName, String firstName, String password, String email) {
        this.profPic = profPic;
        this.dob = dob;
        this.username = username;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public byte[] getProfPic() {
        return profPic;
    }

    public void setProfPic(byte[] profPic) {
        this.profPic = profPic;
    }

    // Utility method to convert image to Base64 String
    public String getImageAsBase64() {
        return Base64.getEncoder().encodeToString(this.profPic);
    }

    public void setImageAsBase64(String base64String) {
        this.profPic = Base64.getDecoder().decode(base64String);
    }

    // Optional toString method for debugging
    @Override
    public String toString() {
        return "users{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }


}

