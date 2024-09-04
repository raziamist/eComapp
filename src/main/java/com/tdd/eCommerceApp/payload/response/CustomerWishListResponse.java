package com.tdd.eCommerceApp.payload.response;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.services.ApplicationContextProvider;
import com.tdd.eCommerceApp.services.CustomerService;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CustomerWishListResponse {

    private Long customerId;
    private String userName;
    private List<String> wishList = new ArrayList<>();
    private String productsName;

    public CustomerWishListResponse(CustomerWishList c,String products) {

        this.customerId = c.getId();
        this.userName = c.getUsername();
        this.productsName = products;

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

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }
}
