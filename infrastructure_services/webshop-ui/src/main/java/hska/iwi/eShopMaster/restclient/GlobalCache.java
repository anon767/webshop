package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalCache {

    private static GlobalCache instance = null;

    private Map<Integer, Product> productCache = new HashMap<Integer, Product>();
    private Map<Integer, Category> categoryCache = new HashMap<Integer, Category>();

    private GlobalCache() {
    }

    public static GlobalCache getInstance() {
        if (instance == null) {
            instance = new GlobalCache();
        }
        return instance;
    }

    public void setProductCache(List<Product> products) {
        products.forEach(product -> this.productCache.put(product.getId(), product));
    }

    public void setCategoryCache(List<Category> categories) {
        categories.forEach(category -> this.categoryCache.put(category.getId(), category));
    }

    List<Product> getProductCache() {
        return new ArrayList<>(this.productCache.values());
    }

    List<Category> getCategoryCache() {
        return (List<Category>) this.categoryCache.values();
    }

    Product getProduct(Integer id) {
        return this.productCache.getOrDefault(id, null);
    }
}
