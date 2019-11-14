package com.hska.webshop.product_category.RestClient;

import org.openapitools.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductCoreFallback implements ProductCoreRestClient {

    private static final String FALLBACK_TEXT = "product_service not found";

    @Override
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        ResponseEntity<Iterable<Product>> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
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
        ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }
}
