package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.Role;
import hska.iwi.eShopMaster.model.User;
import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.restclient.ProductCoreRestClient;
import hska.iwi.eShopMaster.restclient.RoleCoreRestClient;
import hska.iwi.eShopMaster.restclient.UserCoreRestClient;
import org.springframework.beans.factory.annotation.Autowired;


public class UserManagerImpl implements UserManager {
    @Autowired
    private UserCoreRestClient userClient;
    @Autowired
    private RoleCoreRestClient roleClient;
    public UserManagerImpl() {

    }


    public void registerUser(String username, String name, String lastname, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setFirstname(name);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setRoleId(role.getId());
        userClient.addUser(user);
    }


    public User getUserByUsername(String username) {
        return new User();
    }

    public boolean deleteUserById(int id) {
        return false;
    }

    public Role getRoleByLevel(int level) {
        return new Role();
    }

    public boolean doesUserAlreadyExist(String username) {

        return false;
    }


    public boolean validate(User user) {
        return !user.getFirstname().isEmpty() && !user.getPassword().isEmpty();

    }

}
