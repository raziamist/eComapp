package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Modifying
    @Query(value="UPDATE Product AS p set p.quantity = p.quantity-:quantity where id = :productId",nativeQuery = true)
    void updateQuantityOfProduct(Long productId,Integer quantity);



}
