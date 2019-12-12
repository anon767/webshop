package com.hska.webshop.product_category.RestClient;

import org.openapitools.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductCoreFallback implements ProductCoreRestClient {

    private static final String FALLBACK_TEXT = "product_service not found";

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(GlobalCache.getInstance().getProductCache(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addProduct(Product product) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Void> updateProduct(Product product) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Product> getProduct(Integer id) {
        return new ResponseEntity<>(GlobalCache.getInstance().getProduct(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }
}
