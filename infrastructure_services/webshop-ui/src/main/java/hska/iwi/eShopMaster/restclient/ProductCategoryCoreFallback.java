package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCategoryCoreFallback implements ProductCategoryCoreRestClient {

    private static final String FALLBACK_TEXT = "product_category_service not found";

    @Override
    public ResponseEntity<Void> addProduct(Product product) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Void> updateProduct(Product product) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<List<Product>> searchProduct(String description, String minprice, String maxprice) {
        System.out.println("searchProduct: fallback executed");

        float minPrice = 0;
        float maxPrice = Float.MAX_VALUE;
        if (description == null) {
            description = "";
        }
        try {
            if (minprice != null) {
                minPrice = Float.parseFloat(minprice);
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (maxprice != null) {
                maxPrice = Float.parseFloat(maxprice);
            }
        } catch (NumberFormatException e) {
            List<Product> products = new ArrayList<>();
            ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
            response.getHeaders().add("Fallback", FALLBACK_TEXT);
            return response;
        }

        List<Product> products = GlobalCache.getInstance().getProductCache();

        String finalDescription = description;
        float finalMinPrice = minPrice;
        float finalMaxPrice = maxPrice;

        products = products
                .stream()
                .filter(product -> (product.getName().contains(finalDescription.trim()) || product.getDetails().contains(finalDescription.trim())) &&
                        (product.getPrice().floatValue() >= finalMinPrice) &&
                        (product.getPrice().floatValue() <= finalMaxPrice))
                .collect(Collectors.toList());

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
