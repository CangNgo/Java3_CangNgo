/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class Product implements Serializable{
    String ID;
    String name; 
    String DV;
    double price;
    String NCC;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDV() {
        return DV;
    }

    public void setDV(String DV) {
        this.DV = DV;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public Product(String ID, String name, String DV, double price, String NCC) {
        this.ID = ID;
        this.name = name;
        this.DV = DV;
        this.price = price;
        this.NCC = NCC;
    }

    public Product() {
    }
}
