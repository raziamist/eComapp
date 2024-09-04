package com.tdd.eCommerceApp.payload.response;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerWishListResponse {

    private Long customerId;
    private String userName;
    private List<String> wishList = new ArrayList<>();

    public CustomerWishListResponse(CustomerWishList c) {
        this.customerId = c.getId();
        this.userName = c.getUsername();
        wishList.add(c.getProduct().getName());

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }
}
