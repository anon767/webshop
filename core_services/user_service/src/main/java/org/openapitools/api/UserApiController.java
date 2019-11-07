package org.openapitools.api;

import org.openapitools.model.User;
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

//import com.hska.webshop.user.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:17:02.342075+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.userCoreService.base-path:/anon767/HsKA/1.0.0}")
public class UserApiController implements UserApi {

	//@Autowired
	//private UserRepository repository;
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

/*
    @ApiOperation(value = "adds a user", nickname = "addUser", notes = "Adds a user to the system", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "user created"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing user already exists") })
    @RequestMapping(value = "/user",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@ApiParam(value = "user to add"  )  @Valid @RequestBody User user) {
        
        if (!validate(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user = repository.save(user);

        if (user.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    
    private boolean validate(User user) {
        return user.getId() != null;
    }

    @ApiOperation(value = "deletes a user", nickname = "deleteUser", notes = "deletes a user from the system", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "user deleted"),
        @ApiResponse(code = 400, message = "invalid input, object invalid") })
    @RequestMapping(value = "/user",
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@NotNull @ApiParam(value = "the user id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        if (repository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "retrieves user", nickname = "getUser", notes = "get a user", response = User.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "returns the user", response = User.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 404, message = "user not existing") })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@NotNull @ApiParam(value = "the user id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        User user = repository.findOne(id);
        if (user != null) {
        	return new ResponseEntity<>(user, HttpStatus.OK);
        }
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "updates a user", nickname = "updateUser", notes = "updates a user", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "user updated"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 404, message = "this user does not exist") })
    @RequestMapping(value = "/user",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@ApiParam(value = "user to add"  )  @Valid @RequestBody User user) {
        if (!validate(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user = repository.save(user);

        if (user.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    */
}
