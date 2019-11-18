package com.hska.webshop.product_category.RestClient;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.openapitools.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service", fallback = ProductCoreFallback.class, decode404 = true)
public interface ProductCoreRestClient {
    @RequestMapping(value = "/product/getAll", method = RequestMethod.GET)
    ResponseEntity<List<Product>> getAllProducts();

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    ResponseEntity<Void> addProduct(@RequestBody Product product);

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    ResponseEntity<Void> updateProduct(@RequestBody Product product);

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    ResponseEntity<Product> getProduct(@RequestParam(name = "id", required = true) Integer id);

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProduct(@RequestParam(name = "id", required = true) Integer id);
}
