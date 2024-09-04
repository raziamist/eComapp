package com.tdd.eCommerceApp.services;


import com.tdd.eCommerceApp.payload.request.SaleRequest;


public interface SaleService {
    String saleProduct(SaleRequest request);

    String totalSaleAmountOfCurrentDate(Object request);

}
