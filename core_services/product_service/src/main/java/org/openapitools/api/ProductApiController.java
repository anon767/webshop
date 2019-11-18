package org.openapitools.api;

import com.hska.webshop.product.Repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.openapitools.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:08:56.071046+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.hskaWebshop.base-path:}")
public class ProductApiController implements ProductApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Autowired
    private ProductRepository repository;

    @ApiOperation(value = "adds an product", nickname = "addProduct", notes = "Adds an product to the system", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product created"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 409, message = "an existing product already exists")})
    @RequestMapping(value = "/product",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@ApiParam(value = "product item to add") @Valid @RequestBody Product product) {
        if (!validate(product)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        product = repository.save(product);

        if (product.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "deletes a product", nickname = "deleteProduct", notes = "deletes an product from the system", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product deleted"),
            @ApiResponse(code = 400, message = "invalid input, object invalid")})
    @RequestMapping(value = "/product",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@NotNull @ApiParam(value = "the product id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        if (repository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "retrieves product", nickname = "getProduct", notes = "get a product", response = Product.class, responseContainer = "List", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "returns the product", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter"),
            @ApiResponse(code = 404, message = "product not existing")})
    @RequestMapping(value = "/product",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProduct(@NotNull @ApiParam(value = "the product id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        Product product = repository.findOne(id);
        if (!validate(product)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(List.of(product), HttpStatus.OK);
    }

    @ApiOperation(value = "retrieves all products", nickname = "getAllProduct", notes = "gets all products", response = Product.class, responseContainer = "List", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "returns products", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter"),
            @ApiResponse(code = 404, message = "product not existing")})
    @RequestMapping(value = "/product/getAll",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>((List<Product>) repository.findAll(), HttpStatus.OK);
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
        if (!validate(product)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!repository.exists(product.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private boolean validate(Product product) {
        return product.getId() != null;
    }

}
