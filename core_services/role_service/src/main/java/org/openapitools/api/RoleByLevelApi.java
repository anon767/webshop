/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import io.swagger.annotations.*;

import org.openapitools.model.Role;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:11:51.764806+01:00[Europe/Berlin]")

@Validated
@Api(value = "roleByLevel", description = "the roleByLevel API")
public interface RoleByLevelApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "gets a role by level", nickname = "getRoleByLevel", notes = "gets a role by its level", tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "returns the role"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 404, message = "this role does not exist") })
    @RequestMapping(value = "/roleByLevel",
        method = RequestMethod.GET)
    default ResponseEntity<List<Role>> getRoleByLevel(@NotNull @ApiParam(value = "the role level", required = true) @Valid @RequestParam(value = "level", required = true) Integer level) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
