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
        return new User();
    }

    public boolean deleteUserById(int id) {
        return false;
    }

    public Role getRoleByLevel(int level) {
        Role role = new Role();
        role.setId(0);
        return role;
    }

    public boolean doesUserAlreadyExist(String username) {

        return false;
    }


    public boolean validate(User user) {
        return !user.getFirstname().isEmpty() && !user.getPassword().isEmpty();

    }

}
