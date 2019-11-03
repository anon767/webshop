package com.hska.webshop.category_service.repository;


import com.hska.webshop.category_service.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("FROM Category c WHERE LOWER(c.name) LIKE LOWER(?1)")
    public Iterable<Category> getCategoryByName(String name);
}