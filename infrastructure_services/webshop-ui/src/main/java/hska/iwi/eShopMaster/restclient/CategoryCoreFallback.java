package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CategoryCoreFallback implements CategoryCoreRestClient {

    private static final String FALLBACK_TEXT = "category-core-service not found";

    public ResponseEntity<Iterable<Category>> getCategories() {
        return new ResponseEntity<>(GlobalCache.getInstance().getCategoryCache(), HttpStatus.OK);
    }

    public ResponseEntity<Void> addCategory(Category category) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }


    public ResponseEntity<Void> deleteCategory(Integer id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }
}
