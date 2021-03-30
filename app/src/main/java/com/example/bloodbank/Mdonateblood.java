package com.example.bloodbank;

public class Mdonateblood {

    String name,fname,age,phone,address,statuss;

    public Mdonateblood(String name, String fname, String age, String phone, String address, String statuss) {
        this.name = name;
        this.fname = fname;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.statuss = statuss;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getStatuss() {
        return statuss;
    }
}
