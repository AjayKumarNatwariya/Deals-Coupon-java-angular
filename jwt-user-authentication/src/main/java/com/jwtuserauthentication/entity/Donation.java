package com.jwtuserauthentication.entity;

import org.springframework.data.annotation.Id;

public class Donation {
    @Id
    private Long id;
    private String name;
    private String email;
    private int amount;

    public Donation() {
    }

    public Donation(Long id, String name, String email, int amount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
