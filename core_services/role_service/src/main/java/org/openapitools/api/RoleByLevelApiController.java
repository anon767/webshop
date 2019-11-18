package org.openapitools.api;

import com.hska.webshop.role.repository.RoleRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.openapitools.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:11:51.764806+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.roleCoreService.base-path:}")
public class RoleByLevelApiController implements RoleByLevelApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RoleByLevelApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Autowired
    RoleRepository repository;

    @ApiOperation(value = "gets a role by level", nickname = "getRoleByLevel", notes = "gets a role by its level", tags = {"role",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "returns the role"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 404, message = "this role does not exist")})
    @RequestMapping(value = "/roleByLevel",
            method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getRoleByLevel(@NotNull @ApiParam(value = "the role level", required = true) @Valid @RequestParam(value = "level", required = true) Integer level) {
        return new ResponseEntity<>((List<Role>) repository.getRolesByLevel(level), HttpStatus.OK);
    }

}
