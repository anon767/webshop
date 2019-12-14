package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.Role;
import hska.iwi.eShopMaster.model.User;
import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.restclient.RoleCoreRestClient;
import hska.iwi.eShopMaster.restclient.UserCoreRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserCoreRestClient userClient;
    @Autowired
    private RoleCoreRestClient roleClient;
    public UserManagerImpl() {

    }


    public void registerUser(String username, String name, String lastname, String password, Role role) {
        User user = new User();
        user.setId(0);
        user.setUsername(username);
        user.setFirstname(name);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setRoleId(role.getId());
        userClient.addUser(user);
    }


    public User getUserByUsername(String username) {
        return userClient.getUserByUsername(username).getBody();
    }

    public boolean deleteUserById(int id) {
        int statusCode = userClient.deleteUser(id).getStatusCodeValue();
        return statusCode == 204;
    }

    public Role getRoleByLevel(int level) {
        return roleClient.getRoleByLevel(level).getBody().get(0);
    }

    public Role getRole(int id) {
        return roleClient.getRole(id).getBody();
    }

    public boolean doesUserAlreadyExist(String username) {
        return userClient.getUserByUsername(username).getBody() != null;
    }


    public boolean validate(User user) {
        return !user.getFirstname().isEmpty() && !user.getPassword().isEmpty();

    }
}
