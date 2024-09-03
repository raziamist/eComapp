package com.tdd.eCommerceApp.services;


import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;

import java.util.List;


public interface EcommerceService {
   // String addOrEditMemo(MemoRequest request);

    CustomerWishListResponse getWishlistByCustomerId(Long customerId);
    List<Product> findAll();


}
