package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Product;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "product-category-service", decode404 = true)
public interface ProductCategoryCoreRestClient {
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    ResponseEntity<Void> addProduct(@RequestBody Product product);

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    ResponseEntity<Void> updateProduct(@RequestBody Product product);

    @RequestMapping(value = "/product/search", method = RequestMethod.GET)
    ResponseEntity<List<Product>> searchProduct(@ApiParam(value = "description for product or catalog") @Valid @RequestParam(value = "description", required = false) String description, @ApiParam(value = "minimal price") @Valid @RequestParam(value = "minprice", required = false) String minprice,
                                                       @ApiParam(value = "maximal price") @Valid @RequestParam(value = "maxprice", required = false) String maxprice);
    }
