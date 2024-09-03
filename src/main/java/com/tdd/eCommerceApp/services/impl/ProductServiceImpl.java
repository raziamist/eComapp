package com.tdd.eCommerceApp.services.impl;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.request.ProductRequest;
import com.tdd.eCommerceApp.payload.response.ApiResponse;
import com.tdd.eCommerceApp.repository.ProductRepository;
import com.tdd.eCommerceApp.services.ProductService;
import com.tdd.eCommerceApp.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;


    @Override
    public String addOrEditProduct(ProductRequest request) {
        ApiResponse response = new ApiResponse();
        Product product;
        try {
            // For edit Product

            if (request.getId() != null && request.getId() > 0) {
                product = productRepository.findById(request.getId()).get();


                if (product != null && product.getId() > 0) {
                    product.setUpdatedOn(new Date());

                } else {
                    return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
                }
            }

            //For create Product

            else {
                product = new Product();
                product.setCreatedOn(new Date());
            }

            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setQuantity(request.getQuantity());

            productRepository.save(product);

            return CommonUtils.objectToJsonString(response.getSuccessResponse(product));
        } catch (Exception exception) {
            return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        } finally {
            response = null;
            product = null;
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
