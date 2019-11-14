/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Product;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:01:22.748495+01:00[Europe/Berlin]")

@Validated
@Api(value = "product", description = "the product API")
public interface ProductApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "adds an product", nickname = "addProduct", notes = "Adds an product to the system", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "product created"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing product already exists") })
    @RequestMapping(value = "/product",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> addProduct(@ApiParam(value = "product item to add"  )  @Valid @RequestBody Product product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "searches products", nickname = "searchProduct", notes = "Searches for products", response = Product.class, responseContainer = "List", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Product.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/product/search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Product>> searchProduct(@ApiParam(value = "description for product or catalog") @Valid @RequestParam(value = "description", required = false) String description,@ApiParam(value = "minimal price") @Valid @RequestParam(value = "minprice", required = false) String minprice,@ApiParam(value = "maximal price") @Valid @RequestParam(value = "maxprice", required = false) String maxprice) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"price\" : 50,  \"name\" : \"Cat\",  \"details\" : \"fluffy pet\",  \"id\" : 0,  \"category\" : \"Pet\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "updates an product", nickname = "updateProduct", notes = "updates an product", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "product updated"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 404, message = "this product does not exist") })
    @RequestMapping(value = "/product",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<Void> updateProduct(@ApiParam(value = "product item to add"  )  @Valid @RequestBody Product product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}