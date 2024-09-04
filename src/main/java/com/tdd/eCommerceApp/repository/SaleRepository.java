package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.entities.Sale;
import com.tdd.eCommerceApp.payload.response.CustomerWishListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT SUM(s.total_price)  as totalPrice from Sale s where date_format(s.created_on ,'%Y-%m-%d')=:currentDate ",nativeQuery = true)
    Double getTotalSaleAmount(@Param("currentDate") String currentDate);


    //String getMaxSaleDayByTimeRange(@Param("fromDate") String fromDate,@Param("toDate") String toDate);



}
