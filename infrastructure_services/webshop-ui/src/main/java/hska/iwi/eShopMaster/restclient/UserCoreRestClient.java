package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.User;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@FeignClient(name = "api-gateway-service", fallback = UserCoreFallback.class, decode404 = true)
public interface UserCoreRestClient {

    @RequestMapping(value = "/user-service/user", method = RequestMethod.POST)
    ResponseEntity<Void> addUser(@ApiParam(value = "user to add"  )  @Valid @RequestBody User user);

    @RequestMapping(value = "/user-service/user", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@NotNull @ApiParam(value = "the user id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id);

    @RequestMapping(value = "/user-service/user", method = RequestMethod.GET)
    ResponseEntity<User> getUser(@NotNull @ApiParam(value = "the user id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id);

    @RequestMapping(value = "/user-service/user", method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@ApiParam(value = "user to add"  )  @Valid @RequestBody User user);

    @RequestMapping(value = "/user-service/userByUsername", method = RequestMethod.GET)
    ResponseEntity<User> getUserByUsername(@NotNull @ApiParam(value = "the username", required = true) @Valid @RequestParam(value = "username", required = true) String username);

}
