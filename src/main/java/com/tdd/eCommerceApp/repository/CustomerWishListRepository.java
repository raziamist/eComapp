package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.CustomerWishList;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerWishListRepository extends JpaRepository<CustomerWishList, Long> {

    @Query("select new com.tdd.eCommerceApp.payload.response.CustomerWishListResponse(c,:products) " +
            "from CustomerWishList c where c.id = :customerId")
    CustomerWishListResponse getWishListList( @Param("customerId") Long customerId,String products);

    @Query(value ="SELECT p.name from CUSTOMER_WISHLIST cw " +
            "INNER JOIN PRODUCT P ON cw.product_id = p.id " +
            "WHERE cw.customer_id = :customerId ",nativeQuery = true)
    List<String> getProductsByCustomerId(@Param("customerId") Long customerId);
}
