package com.thangdtran.client.controllers;

import com.thangdtran.client.domain.model.Product;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(path = "/product/{product_id}", produces = "application/json")
    public ResponseEntity<Object> productInfo(@PathVariable("product_id") String productId) {
        Product product = new Product();
        product.setProductId(productId);

        if (Integer.parseInt(productId) % 2 == 0) {
            product.setProductName("Iphone Xs");
            product.setCategory("Smartphone");
            product.setPrice(20000000.00);
            product.setDescription("Apple Iphone Xs 2018");
        } else {
            product.setProductName("MacBook Pro");
            product.setCategory("Laptop/PC");
            product.setPrice(35000000.00);
            product.setDescription("Apple MacBook Pro 2019");
        }

        JSONObject responseObject = new JSONObject();
        responseObject.put("product_id", product.getProductId());
        responseObject.put("product_name", product.getProductName());
        responseObject.put("product_price", product.getPrice());
        responseObject.put("product_category", product.getCategory());
        responseObject.put("product_description", product.getDescription());

        return new ResponseEntity<>(responseObject.toString(), HttpStatus.OK);
    }
}
