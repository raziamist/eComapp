package com.tdd.eCommerceApp.controllers;

import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.payload.request.SignUpRequest;
import com.tdd.eCommerceApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/registerCustomer")
    public ResponseEntity<?> registerCustomer(@RequestBody SignUpRequest requestObject) {
        return ResponseEntity.ok(customerService.registerCustomer(requestObject));
    }

    @PostMapping("/customerList")
    public ResponseEntity<?> getCustomerList() {

        return ResponseEntity.ok(customerService.findAll());
    }


    @PostMapping("/createOrUpdateWishList")
    public ResponseEntity<?> createOrUpdateCustomerWishList(@RequestBody CustomerWishList requestObject) {

        return ResponseEntity.ok(customerService.createOrUpdateWishlist(requestObject));
    }
}
