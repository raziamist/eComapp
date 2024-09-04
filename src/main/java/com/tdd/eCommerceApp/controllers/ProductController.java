package com.tdd.eCommerceApp.controllers;

import com.tdd.eCommerceApp.payload.request.ProductRequest;
import com.tdd.eCommerceApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addOrEditProduct")
    public ResponseEntity<?> createOrEditProduct(@RequestBody ProductRequest requestObject) {
        return ResponseEntity.ok(productService.addOrEditProduct(requestObject));
    }

    @GetMapping("/productList")
    public ResponseEntity<?> getProductList() {
        return ResponseEntity.ok(productService.findAll());
    }
}
