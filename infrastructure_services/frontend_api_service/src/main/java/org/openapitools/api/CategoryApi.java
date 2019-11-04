/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Category;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:22:12.049448+01:00[Europe/Berlin]")

@Validated
@Api(value = "category", description = "the category API")
public interface CategoryApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "adds an category", nickname = "addCategory", notes = "Adds an category to the system", tags={ "category", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "category created"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing category already exists") })
    @RequestMapping(value = "/category",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> addCategory(@ApiParam(value = "category item to add"  )  @Valid @RequestBody Category category) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "deletes a category", nickname = "deleteCategory", notes = "deletes an category from the system", tags={ "category", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "category deleted"),
        @ApiResponse(code = 400, message = "invalid input, object invalid") })
    @RequestMapping(value = "/category",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteCategory(@NotNull @ApiParam(value = "the category id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "retrieves all categories", nickname = "getCategories", notes = "get all categories", response = Category.class, responseContainer = "List", tags={ "category", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "get all categories", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/category",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Category>> getCategories() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"name\" : \"Pets\",  \"id\" : 0}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
