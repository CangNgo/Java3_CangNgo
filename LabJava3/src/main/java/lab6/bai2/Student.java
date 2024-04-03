/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6.bai2;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class Student {
    String name, Address,ParentName,Phone,Standard;
    Date date; 

    public Student(String name, String Address, String ParentName, String Phone, String Standard, Date date) {
        this.name = name;
        this.Address = Address;
        this.ParentName = ParentName;
        this.Phone = Phone;
        this.Standard = Standard;
        this.date = date;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String ParentName) {
        this.ParentName = ParentName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String Standard) {
        this.Standard = Standard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
