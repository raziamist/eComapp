package com.tdd.eCommerceApp.services;


import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.payload.request.SignUpRequest;

import java.util.List;


public interface CustomerService {
    String registerCustomer(SignUpRequest request);

    List<Customer> findAll();

    String createOrUpdateWishlist (CustomerWishList request);


}
