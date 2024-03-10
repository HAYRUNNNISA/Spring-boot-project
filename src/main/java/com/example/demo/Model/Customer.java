package com.example.demo.Model;
import jakarta.persistence.Entity;

import java.lang.String;


@Entity(name = "Customers")
public class Customer {

    private int id;
    private String name;
    private String address;
    private String telephone;

    public Customer() {
    }

    public Customer(int id, String name, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address+ '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
