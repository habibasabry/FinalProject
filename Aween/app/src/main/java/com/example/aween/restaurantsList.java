package com.example.aween;

import java.io.Serializable;

public class restaurantsList implements Serializable {

    private String restaurantName;
    private int restaurantImg;
    private int phoneNum;
    private String email;
    private String description;
    private int address;


    //constructor

    public restaurantsList(String restaurantName, int restaurantImg, int PhoneNum, String Email, String Description, int Address) {
        this.restaurantName = restaurantName;
        this.restaurantImg = restaurantImg;
        this.phoneNum = PhoneNum;
        this.email = Email;
        this.description = Description;
        this.address = Address;

    }


    //gitter & sitter

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRestaurantImg() {
        return restaurantImg;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setRestaurantImg(int restaurantImg) {
        this.restaurantImg = restaurantImg;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
