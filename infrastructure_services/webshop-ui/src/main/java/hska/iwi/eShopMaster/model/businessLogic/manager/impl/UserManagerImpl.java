package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.Role;
import hska.iwi.eShopMaster.model.User;
import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;

/**
 * @author knad0001
 */

public class UserManagerImpl implements UserManager {

    public UserManagerImpl() {

    }


    public void registerUser(String username, String name, String lastname, String password, Role role) {

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
