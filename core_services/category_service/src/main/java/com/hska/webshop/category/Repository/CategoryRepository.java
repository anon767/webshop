package com.hska.webshop.category.Repository;

import org.openapitools.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("FROM Category c WHERE LOWER(c.name) LIKE LOWER(?1)")
    Iterable<Category> getCategoryByName(String name);
}
