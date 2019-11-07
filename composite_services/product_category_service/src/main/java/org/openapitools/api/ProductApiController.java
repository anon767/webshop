package org.openapitools.api;

import com.hska.webshop.product_category.RestClient.CategoryCoreFallback;
import com.hska.webshop.product_category.RestClient.CategoryCoreRestClient;
import com.hska.webshop.product_category.RestClient.ProductCoreFallback;
import com.hska.webshop.product_category.RestClient.ProductCoreRestClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.openapitools.model.Category;
import org.openapitools.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:01:22.748495+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.hskaWebshop.base-path:}")
public class ProductApiController implements ProductApi {

    private final NativeWebRequest request;

    @Autowired
    private ProductCoreRestClient productClient;

    @Autowired
    private CategoryCoreRestClient categoryClient;

    @Autowired
    public ProductApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Bean
    public ProductCoreFallback productCoreFallback() {
        return new ProductCoreFallback();
    }

    @Bean
    public CategoryCoreFallback categoryCoreFallback() {
        return new CategoryCoreFallback();
    }

    @ApiOperation(value = "adds an product", nickname = "addProduct", notes = "Adds an product to the system", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product created"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 409, message = "an existing product already exists")})
    @RequestMapping(value = "/product",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@ApiParam(value = "product item to add") @Valid @RequestBody Product product) {
        Category category = getCategoryByName(product.getCategory());
        if (category == null || !validateCategory(category) || !validateProduct(product)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productClient.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "searches products", nickname = "searchProduct", notes = "Searches for products", response = Product.class, responseContainer = "List", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "search results matching criteria", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter")})
    @RequestMapping(value = "/product/search",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Product>> searchProduct(@ApiParam(value = "description for product or catalog") @Valid @RequestParam(value = "description", required = false) String description, @ApiParam(value = "minimal price") @Valid @RequestParam(value = "minprice", required = false) String minprice, @ApiParam(value = "maximal price") @Valid @RequestParam(value = "maxprice", required = false) String maxprice) {
        float minPrice = 0;
        float maxPrice = Float.MAX_VALUE;
        try {
            minPrice = Float.parseFloat(minprice);
        } catch (NumberFormatException e) {
        }
        try {
            maxPrice = Float.parseFloat(maxprice);
        } catch (NumberFormatException e) {
        }
        List<Product> products = this.getProductByNameAndMinMaxPrice(description, minPrice, maxPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }


    @ApiOperation(value = "updates an product", nickname = "updateProduct", notes = "updates an product", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product updated"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 404, message = "this product does not exist")})
    @RequestMapping(value = "/product",
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@ApiParam(value = "product item to add") @Valid @RequestBody Product product) {
        Category category = getCategoryByName(product.getCategory());
        if (category == null || !validateCategory(category) || !validateProduct(product)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productClient.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    private boolean validateCategory(Category category) {
        return category.getId() != null;
    }

    private boolean validateProduct(Product product) {
        return product.getId() != null;
    }

    public List<Product> getProductByNameAndMinMaxPrice(String name, float minPrice, float maxPrice) {
        return ((List<Product>) this.productClient.getAllProducts())
                .stream()
                .filter(product -> product.getName().contains(name) && product.getPrice().floatValue() >= minPrice && product.getPrice().floatValue() <= maxPrice)
                .collect(Collectors.toList());
    }

    public Category getCategoryByName(String name) {
        return ((List<Category>) this.categoryClient.getCategories())
                .stream()
                .filter(category -> category.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }
}
