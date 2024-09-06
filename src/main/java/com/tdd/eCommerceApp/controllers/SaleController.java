package com.tdd.eCommerceApp.controllers;

import com.tdd.eCommerceApp.payload.request.MaxSaleDayRequest;
import com.tdd.eCommerceApp.payload.request.SaleRequest;
import com.tdd.eCommerceApp.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getTopSellingProductsBySaleAmount")
    public ResponseEntity<?> getTopSellingProducts() {
        return ResponseEntity.ok(saleService.getTopSellingProducts());
    }

    @PostMapping("/getTopSellingProductsByNoOfItemsSold")
    public ResponseEntity<?> getTopSellingProductsByNoOfItems() {
        return ResponseEntity.ok(saleService.getTopSellingProductsByNoOfItems());
    }


}
