package com.deal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "deal")
public class Deal {
    @Id
    private Long dealId;
    private String dealLink, dealName, expDate,description;
    private int profitPercent, points;
    private ArrayList<Long> likes, disLikes;
    public Deal() {
    }

    public Deal(Long dealId, String dealLink, String dealName, String expDate, String description, int profitPercent, int points, ArrayList<Long> likes, ArrayList<Long> disLikes) {
        this.dealId = dealId;
        this.dealLink = dealLink;
        this.dealName = dealName;
        this.expDate = expDate;
        this.description = description;
        this.profitPercent = profitPercent;
        this.points = points;
        this.likes = likes;
        this.disLikes = disLikes;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public String getDealLink() {
        return dealLink;
    }

    public void setDealLink(String dealLink) {
        this.dealLink = dealLink;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(int profitPercent) {
        this.profitPercent = profitPercent;
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