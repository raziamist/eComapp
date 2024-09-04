package com.tdd.eCommerceApp.controllers;

import com.tdd.eCommerceApp.payload.request.MaxSaleDayRequest;
import com.tdd.eCommerceApp.payload.request.SaleRequest;
import com.tdd.eCommerceApp.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {


    @Autowired
    SaleService saleService;

    @PostMapping("/saveProductSaleInfo")
    public ResponseEntity<?> productSale(@RequestBody SaleRequest requestObject) {
        return ResponseEntity.ok(saleService.saleProduct(requestObject));
    }

    @PostMapping("/getTotalSaleAmountByCurrentDate")
    public ResponseEntity<?> getTotalSale(@RequestBody Object requestObject) {
        return ResponseEntity.ok(saleService.totalSaleAmountOfCurrentDate(requestObject));
    }

    @PostMapping("/getMaxSaleDay")
    public ResponseEntity<?> getMaxSaleDay(@RequestBody MaxSaleDayRequest requestObject) {
        return ResponseEntity.ok(saleService.getMaxSaleDay(requestObject));
    }

}
