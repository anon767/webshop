package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.Product;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.restclient.CategoryCoreRestClient;
import hska.iwi.eShopMaster.restclient.ProductCategoryCoreRestClient;
import hska.iwi.eShopMaster.restclient.ProductCoreRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class ProductManagerImpl implements ProductManager {


    @Autowired
    private ProductCoreRestClient productClient;

    @Autowired
    private ProductCategoryCoreRestClient productCategoryCoreRestClient;

    @Autowired
    private CategoryCoreRestClient categoryCoreRestClient;

    public ProductManagerImpl() {

    }

    public List<Product> getProducts() {

        return (List<Product>) productClient.getAllProducts().getBody();
    }

    public List<Product> getProductsForSearchValues(String searchDescription,
                                                    Double searchMinPrice, Double searchMaxPrice) {
        return productCategoryCoreRestClient.searchProduct(searchDescription, searchMinPrice.toString(), searchMaxPrice.toString()).getBody();
    }

    public Product getProductById(int id) {
        return productClient.getProduct(id).getBody();
    }

    public Product getProductByName(String name) {
        List<Product> products = getProducts();
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    private Category getCategoryById(int id) {
        List<Category> categories = (List<Category>) this.categoryCoreRestClient.getCategories().getBody();
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public int addProduct(String name, double price, int categoryId, String details) {
        Product p = new Product();
        p.setDetails(details);
        p.setPrice(new BigDecimal(price, MathContext.DECIMAL64));
        p.setName(name);
        p.setCategory(getCategoryById(categoryId).getName());
        productCategoryCoreRestClient.addProduct(p);

        return 0;
    }


    public void deleteProductById(int id) {
        productClient.deleteProduct(id);
    }

    public boolean deleteProductsByCategoryId(int categoryId) {
        Category c = getCategoryById(categoryId);
        for(Product p: this.getProducts()){
            if(p.getCategory().equals(c.getName())) {
                deleteProductById(p.getId());
            }
        }
        return true;
    }

}
