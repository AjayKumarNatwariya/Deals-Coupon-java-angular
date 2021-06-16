package com.jwtuserauthentication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class User{
    @Id
    @Field("_id")
    @JsonIgnore
    private ObjectId userId;
    private String firstName, lastName, userName, password, email, rol;
    private List<Coupon> couponsList = new ArrayList<>();
    private List<Long> couponIdList = new ArrayList<>();
    private List<Deal> dealsList = new ArrayList<>();
    private List<Long> dealIdList = new ArrayList<>();
    private boolean enabled;
    private int points = 0;

    public User() {
    }

    public User(ObjectId userId, String firstName, String lastName, String userName, String password, String email, String rol, List<Coupon> couponsList, List<Long> couponIdList, List<Deal> dealsList, List<Long> dealIdList, boolean enabled, int points) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.couponsList = couponsList;
        this.couponIdList = couponIdList;
        this.dealsList = dealsList;
        this.dealIdList = dealIdList;
        this.enabled = enabled;
        this.points = points;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Coupon> getCouponsList() {
        return couponsList;
    }

    public void setCouponsList(List<Coupon> couponsList) {
        this.couponsList = couponsList;
    }

    public List<Long> getCouponIdList() {
        return couponIdList;
    }

    public void setCouponIdList(List<Long> couponIdList) {
        this.couponIdList = couponIdList;
    }

    public List<Deal> getDealsList() {
        return dealsList;
    }

    public void setDealsList(List<Deal> dealsList) {
        this.dealsList = dealsList;
    }

    public List<Long> getDealIdList() {
        return dealIdList;
    }

    public void setDealIdList(List<Long> dealIdList) {
        this.dealIdList = dealIdList;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}