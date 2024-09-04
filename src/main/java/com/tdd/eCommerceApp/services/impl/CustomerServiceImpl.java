package com.tdd.eCommerceApp.services.impl;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.request.CustomerWishListRequest;
import com.tdd.eCommerceApp.payload.request.ProductRequest;
import com.tdd.eCommerceApp.payload.request.SignUpRequest;
import com.tdd.eCommerceApp.payload.response.ApiResponse;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import com.tdd.eCommerceApp.repository.CustomerRepository;
import com.tdd.eCommerceApp.repository.CustomerWishListRepository;
import com.tdd.eCommerceApp.repository.ProductRepository;
import com.tdd.eCommerceApp.services.CustomerService;
import com.tdd.eCommerceApp.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerWishListRepository customerWishListRepository;


    @Autowired
    ProductRepository productRepository;


    @Override
    public String registerCustomer(SignUpRequest signUpRequest) {
        ApiResponse response = new ApiResponse();
        try {
            //Trim username, mobile, email
            String username, mobile, email;
            username = signUpRequest.getUsername().trim();
            mobile = signUpRequest.getMobile().trim();
            signUpRequest.setUsername(username);
            signUpRequest.setMobile(mobile);


            if (customerRepository.existsByUsername(signUpRequest.getUsername())) {
                return CommonUtils.objectToJsonString(response.getErrorResponse("Username is already taken!"));
            }

            if (customerRepository.existsByMobile(signUpRequest.getMobile())) {
                return CommonUtils.objectToJsonString(response.getErrorResponse("Mobile number is already in use!"));
            }

            // Create new user's account

            Customer customer = new Customer();
            customer.setFullName(signUpRequest.getFullName());
            customer.setUsername(signUpRequest.getUsername());
            customer.setMobile(signUpRequest.getMobile());
            customer.setCreatedOn(new Date());
            customerRepository.save(customer);

            return CommonUtils.objectToJsonString(response.getSuccessResponse(customer));
        } catch (Exception exception) {
            logger.info(exception.getMessage());
             return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public String createWishlist(CustomerWishListRequest request) {

        ApiResponse response = new ApiResponse();
        CustomerWishList customerWishList = null;
        try {
            // For edit customerWishList

            if (request.getId() != null && request.getId() > 0) {
                customerWishList = customerWishListRepository.findById(request.getId()).get();


                if (customerWishList != null && customerWishList.getId() > 0) {
                    customerWishList.setUpdatedOn(new Date());

                } else {
                    return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
                }
            }
            else {

                for (Long productId : request.getProductIds()) {
                    Product product = productRepository.findById(productId).get();
                    customerWishList = new CustomerWishList();
                    customerWishList.setUsername(request.getUsername());
                    customerWishList.setCreatedOn(new Date());
                    customerWishList.setCustomerId(request.getCustomerId());
                    customerWishList.setProduct(product);
                    customerWishListRepository.save(customerWishList);

                }
            }



            return CommonUtils.objectToJsonString(response.getSuccessResponse(customerWishList));
        } catch (Exception exception) {
            return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        } finally {
            response = null;
            customerWishList = null;
        }
    }


    @Override
    public String getWishListByCustomerId(Object request) {
        ApiResponse response = new ApiResponse();
        CustomerWishListResponse customerWishListResponse = null;
        String customerId = ((LinkedHashMap) request).get("customerId").toString();
        if (customerId != null) {
            Long id = Long.parseLong("0" + customerId);
            List<String> products = customerWishListRepository.getProductsByCustomerId(id);
            customerWishListResponse = customerWishListRepository.getWishListList(id,products.toString());
            return CommonUtils.objectToJsonString(customerWishListResponse);
        }
        else
        {
            return CommonUtils.objectToJsonString(response.getErrorResponse("No wishlist available for this customer !"));
        }
    }
}
