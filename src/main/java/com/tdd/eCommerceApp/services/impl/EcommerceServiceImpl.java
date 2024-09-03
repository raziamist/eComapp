package com.tdd.eCommerceApp.services.impl;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import com.tdd.eCommerceApp.repository.CustomerRepository;
import com.tdd.eCommerceApp.repository.ProductRepository;
import com.tdd.eCommerceApp.services.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EcommerceServiceImpl implements EcommerceService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;


    @Override
    public CustomerWishListResponse getWishlistByCustomerId(Long customerId) {
        return customerRepository.getWishListList(customerId);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


}
