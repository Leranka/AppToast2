package com.example.admin.apptoast;

/**
 * Created by Admin on 05-Feb-18.
 */

public class Ticket {

    private String tickectType, placeTo,placeFrom,price,date,accountNo;
    private int id;

    public String getTickectType() {
        return tickectType;
    }

    public void setTickectType(String tickectType) {
        this.tickectType = tickectType;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public void setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
    }

    public String getFromDate() {
        return placeFrom;
    }

    public void setFromDate(String fromDate) {
        this.placeFrom = fromDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
