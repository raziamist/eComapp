package com.tdd.eCommerceApp.payload.request;

import java.util.List;

public class MaxSaleDayRequest {


    private String fromDate;

    private String toDate;

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
}
