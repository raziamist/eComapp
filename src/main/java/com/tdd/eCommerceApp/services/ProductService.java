package com.tdd.eCommerceApp.services;


import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.request.ProductRequest;

import java.util.List;


public interface ProductService {
    String addOrEditProduct(ProductRequest request);

    List<Product> findAll();


}
