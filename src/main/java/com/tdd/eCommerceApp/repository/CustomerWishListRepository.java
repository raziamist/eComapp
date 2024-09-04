package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerWishListRepository extends JpaRepository<CustomerWishList, Long> {

    @Query("select new com.tdd.eCommerceApp.payload.response.CustomerWishListResponse(c) " +
            "from CustomerWishList c join c.product p where c.id = :customerId")
    CustomerWishListResponse getWishListList( @Param("customerId") Long customerId);
}
