package com.example.blogheaven.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", length = 20)
    private String street;

    @Column(name = "postal_code", length = 6)
    private int postalCode;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "country", length = 15)
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
