package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.Product;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.restclient.ProductCategoryCoreRestClient;
import hska.iwi.eShopMaster.restclient.ProductCoreRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl implements ProductManager {


    @Autowired
    private ProductCoreRestClient productClient;

    @Autowired
    private ProductCategoryCoreRestClient productCategoryCoreRestClient;

    public ProductManagerImpl() {

    }

    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    public List<Product> getProductsForSearchValues(String searchDescription,
                                                    Double searchMinPrice, Double searchMaxPrice) {
        return new ArrayList<>();
    }

    public Product getProductById(int id) {
        return new Product();
    }

    public Product getProductByName(String name) {
        return new Product();
    }

    public int addProduct(String name, double price, int categoryId, String details) {
        int productId = -1;


        return productId;
    }


    public void deleteProductById(int id) {

    }

    public boolean deleteProductsByCategoryId(int categoryId) {
        // TODO Auto-generated method stub
        return false;
    }

}
