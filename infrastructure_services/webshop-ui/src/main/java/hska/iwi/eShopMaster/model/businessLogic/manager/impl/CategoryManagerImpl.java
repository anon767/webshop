package hska.iwi.eShopMaster.model.businessLogic.manager.impl;


import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;

import java.util.ArrayList;
import java.util.List;

public class CategoryManagerImpl implements CategoryManager {

    public CategoryManagerImpl() {

    }

    public List<Category> getCategories() {
        return new ArrayList<>();
    }

    public Category getCategory(int id) {
        return new Category();
    }

    public Category getCategoryByName(String name) {
        return new Category();
    }

    public void addCategory(String name) {

    }

    public void delCategory(Category cat) {

// 		Products are also deleted because of relation in Category.java 

    }

    public void delCategoryById(int id) {

    }
}
