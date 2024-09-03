package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new com.tdd.eCommerceApp.payload.response.CustomerWishListResponse(c) " +
            "from Customer c where c.id = :customerId")
    CustomerWishListResponse getWishListList( @Param("customerId") Long customerId);



}
