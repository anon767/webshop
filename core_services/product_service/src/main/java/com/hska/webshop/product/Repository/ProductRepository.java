package com.hska.webshop.product.Repository;

import org.openapitools.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
