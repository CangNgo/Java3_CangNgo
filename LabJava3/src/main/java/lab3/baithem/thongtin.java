/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.baithem;

/**
 *
 * @author acer
 */
public class thongtin {
        String fname; 
    String lname;
    String contact;
    String address;
    String highest;
    String spec;
    String Errol;
    String hobbies;
    String soprt;

    public thongtin() {
    }

    public thongtin(String fname, String lname, String contact, String address, String highest, String spec, String Errol, String hobbies, String soprt) {
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.address = address;
        this.highest = highest;
        this.spec = spec;
        this.Errol = Errol;
        this.hobbies = hobbies;
        this.soprt = soprt;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getErrol() {
        return Errol;
    }

    public void setErrol(String Errol) {
        this.Errol = Errol;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getSoprt() {
        return soprt;
    }

    public void setSoprt(String soprt) {
        this.soprt = soprt;
    }

 
}
