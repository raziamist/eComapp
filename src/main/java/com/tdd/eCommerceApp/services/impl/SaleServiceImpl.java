package com.tdd.eCommerceApp.services.impl;

import com.tdd.eCommerceApp.entities.Product;
import com.tdd.eCommerceApp.entities.Sale;
import com.tdd.eCommerceApp.payload.request.MaxSaleDayRequest;
import com.tdd.eCommerceApp.payload.request.SaleInfoRequest;
import com.tdd.eCommerceApp.payload.request.SaleRequest;
import com.tdd.eCommerceApp.payload.response.ApiResponse;
import com.tdd.eCommerceApp.repository.ProductRepository;
import com.tdd.eCommerceApp.repository.SaleRepository;
import com.tdd.eCommerceApp.services.SaleService;
import com.tdd.eCommerceApp.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);


    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;


    @Override
    public String saleProduct(SaleRequest request) {


        ApiResponse response = new ApiResponse();
        Sale sale=null;
        try {

            for(SaleInfoRequest saleInfoRequest :request.getSaleInfoList())
            {
                sale =new Sale();
                sale.setCreatedOn(new Date());
                sale.setCustomerId(saleInfoRequest.getCustomerId());
                sale.setProductId(saleInfoRequest.getProductId());
                sale.setQuantity(saleInfoRequest.getQuantity());
                Product product = productRepository.findById(saleInfoRequest.getProductId()).get();
                sale.setUnitPrice(product.getPrice());
                double price =product.getPrice();
                sale.setTotalPrice(price*saleInfoRequest.getQuantity());
                saleRepository.save(sale);
            }


            return CommonUtils.objectToJsonString(response.getSuccessResponse(sale));
        } catch (Exception exception) {
            return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        } finally {
            response = null;
            sale = null;
        }
    }

    @Override
    public String totalSaleAmountOfCurrentDate(Object request) {


        ApiResponse response = new ApiResponse();
        Double totalSaleAmount=0.0;
        try {


            String currentDate =((LinkedHashMap) request).get("currentDate").toString();
            totalSaleAmount = saleRepository.getTotalSaleAmount(currentDate);


            return CommonUtils.objectToJsonString(response.getSuccessResponse(totalSaleAmount));
        } catch (Exception exception) {
            return CommonUtils.objectToJsonString(response.getErrorResponse("Bad request!"));
        } finally {
            response = null;
            totalSaleAmount = 0.0;
        }
    }

    @Override
    public String getMaxSaleDay(MaxSaleDayRequest request) {
       /* String fromDate = request.getFromDate();
        String toDate = request.getFromDate();

        String maxSaleDay = saleRepository.getMaxSaleDayByTimeRange(fromDate,toDate);*/
        return null;
    }

}
