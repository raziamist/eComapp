package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Customer;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select new com.tdd.eCommerceApp.payload.response.CustomerWishListResponse(c) " +
            "from Customer c where c.id = :customerId")
    CustomerWishListResponse getWishListList( @Param("customerId") Long customerId);

    Boolean existsByMobileOrEmail(String mobile, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByMobile(String mobile);



}
