package com.example.aween;

import java.io.Serializable;

public class hotelsList implements Serializable {

    private String hotelName;
    private int hotelImg;
    private int hotelPhoneNum;
    private String hotelEmail;
    private String hotelDescription;
    private int address;



    //constructor

    public hotelsList(String hotelName, int hotelImg, int PhoneNum, String Email, String Description, int Address) {
        this.hotelName = hotelName;
        this.hotelImg = hotelImg;
        this.hotelPhoneNum = PhoneNum;
        this.hotelEmail = Email;
        this.hotelDescription = Description;
        this.address = Address;

    }




    //gitter & sitter


    public int getHotelPhoneNum() {
        return hotelPhoneNum;
    }

    public void setHotelPhoneNum(int hotelPhoneNum) {
        this.hotelPhoneNum = hotelPhoneNum;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelImg() {
        return hotelImg;
    }

    public void setHotelImg(int hotelImg) {
        this.hotelImg = hotelImg;
    }
}
