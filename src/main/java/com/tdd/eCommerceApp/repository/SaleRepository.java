package com.tdd.eCommerceApp.repository;

import com.tdd.eCommerceApp.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT SUM(s.total_price)  as totalPrice from Sale s where date_format(s.created_on ,'%Y-%m-%d')=:currentDate ",nativeQuery = true)
    Double getTotalSaleAmount(@Param("currentDate") String currentDate);


    @Query(value = "select date_format(created_on,'%Y-%m-%d') saleDay  from Sale s\n" +
            "where s.created_on between :fromDate and :toDate \n" +
            "group by saleDay \n" +
            "order by sum(s.total_price) desc    \n" +
            "limit 0,1 ",nativeQuery = true)
    String getMaxSaleDayByTimeRange(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

    @Query(value="UPDATE Prooduct AS p set p.quantity = p.quantity-:quantity where id = :productId",nativeQuery = true)
    Long updateQuantityOfProduct(Long productId,Integer quantity);

   /* @Query(value = "    select p.name,s.product_id,sum(s.total_price) totalSale from Sale s\n" +
            "    inner join product p on s.product_id =p.id\n" +
            "    where s.created_on between '2024-09-05' and '2024-09-09'\n" +
            "    group by product_id\n" +
            "    order by totalSale desc\n" +
            "    limit 0,5 ",nativeQuery = true)
    MaxSaleDayResponse getMaxSaleDayByTimeRange(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

*/

}
