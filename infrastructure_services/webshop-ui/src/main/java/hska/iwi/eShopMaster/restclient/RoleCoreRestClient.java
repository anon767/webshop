package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Role;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@FeignClient(name = "category-service", decode404 = true)
public interface RoleCoreRestClient {

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    ResponseEntity<Void> addRole(@ApiParam(value = "role to add") @Valid @RequestBody Role role);

    @RequestMapping(value = "/role", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRole(@NotNull @ApiParam(value = "the role id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id);

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    ResponseEntity<Role> getRole(@NotNull @ApiParam(value = "the role id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id);

    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    ResponseEntity<Void> updateRole(@ApiParam(value = "role to update") @Valid @RequestBody Role role);

    @RequestMapping(value = "/roleByLevel", method = RequestMethod.GET)
    ResponseEntity<List<Role>> getRoleByLevel(@NotNull @ApiParam(value = "the role level", required = true) @Valid @RequestParam(value = "level", required = true) Integer level);

}
