package org.openapitools.api;

import org.openapitools.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.hska.webshop.role.repository.RoleRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:11:51.764806+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.roleCoreService.base-path:}")
public class RoleApiController implements RoleApi {

	@Autowired
	private RoleRepository repository;
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RoleApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @ApiOperation(value = "adds a role", nickname = "addRole", notes = "Adds a role to the system", tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "role created"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing role already exists") })
    @RequestMapping(value = "/role",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<Void> addRole(@ApiParam(value = "role to add"  )  @Valid @RequestBody Role role) {
        
        if (!validate(role)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        role = repository.save(role);

        if (role.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    private boolean validate(Role role) {
        return role.getId() != null;
    }

    @ApiOperation(value = "deletes a role", nickname = "deleteRole", notes = "deletes a role from the system", tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "role deleted"),
        @ApiResponse(code = 400, message = "invalid input, object invalid") })
    @RequestMapping(value = "/role",
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRole(@NotNull @ApiParam(value = "the role id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        if (repository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "retrieves role", nickname = "getRole", notes = "get a role", response = Role.class, tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "returns the role", response = Role.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 404, message = "role not existing") })
    @RequestMapping(value = "/role",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<Role> getRole(@NotNull @ApiParam(value = "the role id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
       Role role = repository.findOne(id);
       if (role != null) {
    	return new ResponseEntity<>(role, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "updates a role", nickname = "updateRole", notes = "updates a role", tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "role updated"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 404, message = "this role does not exist") })
    @RequestMapping(value = "/role",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRole(@ApiParam(value = "role to update"  )  @Valid @RequestBody Role role) {
        
        if (!validate(role)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Role repoRole = repository.findOne(role.getId());
        if(repoRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        role = repository.save(role);

        if (role.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
