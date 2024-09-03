package com.tdd.eCommerceApp.payload.response;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerWishListResponse {

    private Long customerId;
    private String customerName;
    private List<String> wishList = new ArrayList<>();

    public CustomerWishListResponse(Customer c) {
        this.customerId = c.getId();
        this.customerName = c.getFullName();
        for(Product product :c.getCustomerWishlist())
        {
            wishList.add(product.getName());
        }
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }
}
