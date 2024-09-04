package com.tdd.eCommerceApp.services;


import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.payload.request.CustomerWishListRequest;
import com.tdd.eCommerceApp.payload.request.SignUpRequest;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;

import java.util.List;


public interface CustomerService {
    String registerCustomer(SignUpRequest request);

    List<Customer> findAll();

    String createWishlist (CustomerWishListRequest request);

    String getWishListByCustomerId (Object request);
}
