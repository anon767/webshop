package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.Product;
import hska.iwi.eShopMaster.model.Role;
import hska.iwi.eShopMaster.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalCache {

    private static GlobalCache instance = null;

    private Map<Integer, Product> productCache = new HashMap<Integer, Product>();
    private Map<Integer, Category> categoryCache = new HashMap<Integer, Category>();
    private Map<Integer, Role> roleCache = new HashMap<Integer, Role>();
    private Map<Integer, User> userCache = new HashMap<Integer, User>();

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

    public void addOrUpdateRoleInCache(Role role) {
        if (role != null) {
            System.out.println("adding/updating role in cache:");
            System.out.println(role.toString());
            roleCache.put(role.getId(), role);
        }
    }

    public void addOrUpdateUserInCache(User user) {
        if (user != null) {
            System.out.println("adding/updating user in cache:");
            System.out.println(user.toString());
            userCache.put(user.getId(), user);
        }
    }

    public List<Product> getProductCache() {
        return new ArrayList<>(this.productCache.values());
    }

    public List<Category> getCategoryCache() {
        return (List<Category>) this.categoryCache.values();
    }

    public Product getProduct(Integer id) {
        return this.productCache.getOrDefault(id, null);
    }

    public Role getRole(Integer id) { return this.roleCache.getOrDefault(id, null); }

    public User getUser(Integer id) { return this.userCache.getOrDefault(id, null); }

    public User getUserByUsername(String username){

        System.out.println("all Users in Cache:");
        for(Map.Entry<Integer, User> entry : userCache.entrySet()){
            User user = entry.getValue();
            System.out.println(user.toString());
            if(user.getUsername().equals(username)){
                System.out.println("Returning User from Cache:");
                System.out.println(user.toString());
                return user;
            }
        }
        return null;
    }
}
