package com.tdd.eCommerceApp.services.impl;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.payload.request.SignUpRequest;
import com.tdd.eCommerceApp.payload.response.ApiResponse;
import com.tdd.eCommerceApp.repository.CustomerRepository;
import com.tdd.eCommerceApp.services.CustomerService;
import com.tdd.eCommerceApp.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Autowired
    CustomerRepository customerRepository;


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

            return CommonUtils.objectToJsonString(response.getErrorResponse("Bad Request"));
        } catch (Exception exception) {
            logger.info(exception.getMessage());
             return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
