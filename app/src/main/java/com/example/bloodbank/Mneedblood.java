package com.example.bloodbank;

public class Mneedblood {
    String pname,cnics,spiners,phone,hnames,anames,aphones,status;

    public Mneedblood(String pname, String cnics, String spiners, String phone, String hnames, String anames, String aphones,String status) {
        this.pname = pname;
        this.cnics = cnics;
        this.spiners = spiners;
        this.phone = phone;
        this.hnames = hnames;
        this.anames = anames;
        this.aphones = aphones;
        this.status=status;

    }

    public String getPname() {
        return pname;
    }

    public String getCnics() {
        return cnics;
    }

    public String getSpiners() {
        return spiners;
    }

    public String getPhone() {
        return phone;
    }

    public String getHnames() {
        return hnames;
    }

    public String getAnames() {
        return anames;
    }

    public String getAphones() {
        return aphones;
    }

    public String getStatus() {
        return status;
    }
}

