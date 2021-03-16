package com.example.cclecc;

public class Users {

    private String name;
    private String address;
    private String number;

    public Users(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
