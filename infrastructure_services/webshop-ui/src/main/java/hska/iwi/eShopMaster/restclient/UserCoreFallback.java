package hska.iwi.eShopMaster.restclient;

import hska.iwi.eShopMaster.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserCoreFallback implements UserCoreRestClient {

    private static final String FALLBACK_TEXT = "user-core-service not found";

    @Override
    public ResponseEntity<Void> addUser(User user) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<User> getUser(Integer id) {
        return new ResponseEntity<>(GlobalCache.getInstance().getUser(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateUser(User user) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Fallback", FALLBACK_TEXT);
        return response;
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        User user = GlobalCache.getInstance().getUserByUsername(username);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
