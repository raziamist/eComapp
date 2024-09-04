package com.tdd.eCommerceApp.payload.request;

import java.util.List;

public class SaleRequest {


    private List<SaleInfoRequest> saleInfoList;

    public List<SaleInfoRequest> getSaleInfoList() {
        return saleInfoList;
    }

    public void setSaleInfoList(List<SaleInfoRequest> saleInfoList) {
        this.saleInfoList = saleInfoList;
    }
}
