package org.openapitools.api;

import org.openapitools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.hska.webshop.user.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:17:02.342075+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.userCoreService.base-path:/anon767/HsKA/1.0.0}")
public class UserByUsernameApiController implements UserByUsernameApi {

	@Autowired
    UserRepository repository;
    
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserByUsernameApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @ApiOperation(value = "gets a user by its username", nickname = "getUserByUsername", notes = "gets a user by its username", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "returns the user"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 404, message = "this user does not exist") })
    @RequestMapping(value = "/userByUsername",
        method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUsername(@NotNull @ApiParam(value = "the username", required = true) @Valid @RequestParam(value = "username", required = true) String username) {
    	
    	Iterable<User> users = repository.getUserByUsername(username);
    	if (users.iterator().hasNext()) {
    		User user = users.iterator().next();
    		return new ResponseEntity<>(user, HttpStatus.OK);
    	}
    	//Iterator<User> iterator = repository.getRolesByLevel(level).iterator();
        //while(iterator.hasNext()) {
        //	roles.add(iterator.next());
        //}
    	//return new ResponseEntity<>(roles, HttpStatus.OK);
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
