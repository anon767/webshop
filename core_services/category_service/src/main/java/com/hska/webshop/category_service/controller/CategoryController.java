package com.hska.webshop.category_service.controller;


import com.hska.webshop.category_service.api.CategoryApi;
import com.hska.webshop.category_service.entity.Category;
import com.hska.webshop.category_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class CategoryController implements CategoryApi {
    private final static Logger LOGGER = Logger.getLogger(CategoryController.class.getSimpleName());


    @Autowired
    private CategoryRepository repo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Category>> getCategories(
            @RequestParam(name = "name", required = false) String name) {
        return validate(name) ? new ResponseEntity<>(repo.getCategoryByName(name), HttpStatus.OK)
                : new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Integer> addCategory(@RequestBody(required = true) Category category) {
        if (!validate(category) || validate(category.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        category = repo.save(category);

        if (category.getId() != null) {
            return new ResponseEntity<Integer>(category.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategory(@PathVariable(name = "id", required = true) long id) {
        Category category = repo.findOne(id);
        LOGGER.info("category=" + category);
        if (validate(category)) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "id", required = true) long id) {
        if (repo.findOne(id) == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        repo.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    private boolean validate(Object obj) {
        return obj != null;
    }

    private boolean validate(String str) {
        return str != null && !str.isEmpty();
    }


    @Override
    public Void addCategory(com.hska.webshop.category_service.api.model.Category category, HttpSession httpSession) {
        return null;
    }

    @Override
    public Void deleteCategory(Integer categoryid, HttpSession httpSession) {
        return null;
    }

    @Override
    public List<com.hska.webshop.category_service.api.model.Category> getCategories(HttpSession httpSession) {
        return null;
    }
}
