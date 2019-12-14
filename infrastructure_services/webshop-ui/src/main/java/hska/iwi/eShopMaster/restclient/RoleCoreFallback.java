package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RoleCoreFallback implements RoleCoreRestClient {

    private static final String FALLBACK_TEXT = "role-core-service not found";

    @Override
    public ResponseEntity<Void> addRole(Role role) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Void> deleteRole(Integer id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Role> getRole(Integer id) {
        return new ResponseEntity<>(GlobalCache.getInstance().getRole(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateRole(Role role) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<List<Role>> getRoleByLevel(Integer level) {
        ResponseEntity<List<Role>> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }
}
