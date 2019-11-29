package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "category-service", fallback = CategoryCoreFallback.class, decode404 = true)
public interface CategoryCoreRestClient {
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    ResponseEntity<Iterable<Category>> getCategories();

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    ResponseEntity<Void> addCategory(@RequestBody(required = true) Category category);

    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCategory(@RequestParam(name = "id", required = true) Integer id);
}
