package com.example.android.carrental.SystemDatabase;

public class RentCarModel {
    private String type;
    private String occasion;
    private String price;
    private String dateFrom;
    private String dateTo;
    private String userName;
    private String userPhone;
    private String fromDestination;
    private String toDestination;

    public RentCarModel() {
    }


    public RentCarModel(String type, String occasion, String price, String dateFrom, String dateTo, String userName, String userPhone, String fromDestination, String toDestination) {
        this.type = type;
        this.occasion = occasion;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.userName = userName;
        this.userPhone = userPhone;
        this.fromDestination = fromDestination;
        this.toDestination = toDestination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }
}

