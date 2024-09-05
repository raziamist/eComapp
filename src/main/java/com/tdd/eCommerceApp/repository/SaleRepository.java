package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Sale;
import com.tdd.eCommerceApp.payload.response.TopSellingProductsByNumOfItemsResponse;
import com.tdd.eCommerceApp.payload.response.TopSellingProductsBySaleAmountResponse;
import com.tdd.eCommerceApp.payload.response.MaxSaleDayResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT SUM(s.total_price)  as totalPrice from Sale s where date_format(s.created_on ,'%Y-%m-%d')=:currentDate ",nativeQuery = true)
    Double getTotalSaleAmount(@Param("currentDate") String currentDate);

   @Query(value = "select date_format(created_on,'%Y-%m-%d') saleDay,sum(s.total_price) saleAmount from Sale s\n" +
           "where s.created_on between :fromDate and :toDate \n" +
           "group by saleDay \n" +
           "order by saleAmount desc    \n" +
           "limit 0,1 ",nativeQuery = true)
   MaxSaleDayResponse getMaxSaleDayByTimeRange(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

    @Query(value="UPDATE Prooduct AS p set p.quantity = p.quantity-:quantity where id = :productId",nativeQuery = true)
    Long updateQuantityOfProduct(Long productId,Integer quantity);

    @Query(value = "select p.name AS productName,sum(s.total_price) totalSaleAmount from Sale s\n" +
            "inner join product p on s.product_id =p.id\n " +
            "group by product_id \n " +
            "order by totalSaleAmount  desc \n" +
            "limit 0,5",nativeQuery = true)
    List<TopSellingProductsBySaleAmountResponse> getBestSellingProductsBySaleAmount();

    @Query(value = "    select p.name,s.product_id,sum(s.quantity)numberOfItems from Sale s\n" +
            "    inner join product p on s.product_id =p.id\n" +
            "    WHERE\n" +
            "    date_format(s.created_on,'%Y-%m-%d')  >= DATE_FORMAT( CURRENT_DATE - INTERVAL 1 MONTH,'%Y-%m-%d')\n" +
            "    AND\n" +
            "    date_format(s.created_on,'%Y-%m-%d') < DATE_FORMAT( CURRENT_DATE, '%Y-%m-01' )\n" +
            "    group by product_id\n" +
            "    order by numberOfItems desc\n" +
            "    limit 0,5",nativeQuery = true)
    List<TopSellingProductsByNumOfItemsResponse> getBestSellingProductsByNoOfItems();


}
