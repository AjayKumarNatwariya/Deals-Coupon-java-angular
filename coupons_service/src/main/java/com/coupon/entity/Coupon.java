package com.coupon.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "coupon")
public class Coupon {
    @Id
    private Long couponId;
    private String productLink, productName, expDate, couponCode;
    private int profitPercent, productPrice, productCost, points;
    private ArrayList<Long> likes, disLikes;
    public Coupon() {
    }

    public Coupon(Long couponId, String productLink, String productName, String expDate, String couponCode, int profitPercent, int productPrice, int productCost, int points, ArrayList<Long> likes, ArrayList<Long> disLikes) {
        this.couponId = couponId;
        this.productLink = productLink;
        this.productName = productName;
        this.expDate = expDate;
        this.couponCode = couponCode;
        this.profitPercent = profitPercent;
        this.productPrice = productPrice;
        this.productCost = productCost;
        this.points = points;
        this.likes = likes;
        this.disLikes = disLikes;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(int profitPercent) {
        this.profitPercent = profitPercent;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<Long> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Long> likes) {
        this.likes = likes;
    }

    public ArrayList<Long> getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(ArrayList<Long> disLikes) {
        this.disLikes = disLikes;
    }
}