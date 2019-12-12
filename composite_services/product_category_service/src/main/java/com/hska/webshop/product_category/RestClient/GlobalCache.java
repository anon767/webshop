package com.hska.webshop.product_category.RestClient;

import org.openapitools.model.Category;
import org.openapitools.model.Product;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GlobalCache {

    private static GlobalCache instance = null;

    private Map<Long, Product> productCache = new LinkedHashMap<Long, Product>();
    private Map<Long, Category> categoryCache = new LinkedHashMap<Long, Category>();

    private GlobalCache(){}

    public static GlobalCache getInstance()
    {
        if(instance == null)
            instance = new GlobalCache();
        return instance;
    }

    public void setProductCache(List<Product> products)
    {
        products.forEach(product -> {
            this.productCache.put(Long.valueOf(product.getId()),product);
        });
    }

    public void setCategoryCache(List<Category> categories)
    {
        categories.forEach(category -> {
            this.categoryCache.put(Long.valueOf(category.getId()),category);
        });
    }

    public List<Product> getProductCache()
    {
        return (List<Product>)this.productCache.values();
    }

    public List<Category> getCategoryCache()
    {
        return (List<Category>)this.categoryCache.values();
    }

    public Product getProduct(Integer id)
    {
        return this.productCache.get(id);
    }
}
