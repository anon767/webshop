/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import io.swagger.annotations.*;
import org.openapitools.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@Validated
@Api(value = "product", description = "the product API")
public interface ProductApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "adds an product", nickname = "addProduct", notes = "Adds an product to the system", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product created"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 409, message = "an existing product already exists")})
    @RequestMapping(value = "/product",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<Void> addProduct(@ApiParam(value = "product item to add") @Valid @RequestBody Product product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "deletes a product", nickname = "deleteProduct", notes = "deletes an product from the system", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product deleted"),
            @ApiResponse(code = 400, message = "invalid input, object invalid")})
    @RequestMapping(value = "/product",
            method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteProduct(@NotNull @ApiParam(value = "the product id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @ApiOperation(value = "retrieves all products", nickname = "getAllProduct", notes = "gets all products", response = Product.class, responseContainer = "List", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "returns products", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter"),
            @ApiResponse(code = 404, message = "product not existing")})
    @RequestMapping(value = "/product/getAll",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "retrieves product", nickname = "getProduct", notes = "get a product", response = Product.class, responseContainer = "List", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "returns the product", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter"),
            @ApiResponse(code = 404, message = "product not existing")})
    @RequestMapping(value = "/product",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<List<Product>> getProduct(@NotNull @ApiParam(value = "the product id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"price\" : 50,  \"name\" : \"Cat\",  \"details\" : \"fluffy pet\",  \"id\" : 0,  \"category\" : \"Pet\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "updates an product", nickname = "updateProduct", notes = "updates an product", tags = {"product",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "product updated"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 404, message = "this product does not exist")})
    @RequestMapping(value = "/product",
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    default ResponseEntity<Void> updateProduct(@ApiParam(value = "product item to add") @Valid @RequestBody Product product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}