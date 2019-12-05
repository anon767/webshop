package hska.iwi.eShopMaster.model.businessLogic.manager.impl;


import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.restclient.CategoryCoreRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryManagerImpl implements CategoryManager {


    @Autowired
    private CategoryCoreRestClient categoryClient;

    public CategoryManagerImpl() {

    }

    public List<Category> getCategories() {

        return (List<Category>) categoryClient.getCategories().getBody();
    }

    public Category getCategory(int id) {
        List<Category> categories = this.getCategories();
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Category getCategoryByName(String name) {
        List<Category> categories = this.getCategories();
        for (Category c : categories) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void addCategory(String name) {
        Category c = new Category();
        c.setName(name);
    categoryClient.addCategory(c);
    }

    public void delCategory(Category cat) {
        categoryClient.deleteCategory(cat.getId());
    }

    public void delCategoryById(int id) {
        categoryClient.deleteCategory(id);
    }
}
