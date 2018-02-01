package com.example.admin.apptoast;

/**
 * Created by Admin on 01-Feb-18.
 */

public class TripPojo {

    private String placeFrom, placeTo,fromDate,toDate,numBuS,TypeTrips;
    private int id;


    public TripPojo() {
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public void setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getNumBuS() {
        return numBuS;
    }

    public void setNumBuS(String numBuS) {
        this.numBuS = numBuS;
    }

    public String getTypeTrips() {
        return TypeTrips;
    }

    public void setTypeTrips(String typeTrips) {
        TypeTrips = typeTrips;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
