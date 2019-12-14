package hska.iwi.eShopMaster.controller;

import hska.iwi.eShopMaster.model.Role;
import hska.iwi.eShopMaster.model.User;
import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.CategoryManagerImpl;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.ProductManagerImpl;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.UserManagerImpl;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginAction extends ActionSupport {

	/**
     *
     */
	private static final long serialVersionUID = -983183915002226000L;
	private String username = null;
	private String password = null;
	private String firstname;
	private String lastname;
	private String role;
	@Autowired
	private CategoryManagerImpl categoryManager;

	@Autowired
	private UserManagerImpl userManager;

	@Autowired
	private ProductManagerImpl productManager;

	@Override
	public String execute() throws Exception {

		// Return string:
		String result = "input";

		// Get user from DB:
		User user = userManager.getUserByUsername(getUsername());

		// Does user exist?
		if (user == null) {
			addActionError(getText("error.username.wrong"));
			return result;
		}

		// Is the password correct?
		if (!user.getPassword().equals(getPassword())) {
			addActionError(getText("error.password.wrong"));
			return result;
		}

		final Integer roleId = user.getRoleId();
		if (roleId == null) {
			System.out.println("roleId is null");
			return result;
		}

		Role role = userManager.getRole(roleId);
		if (role == null) {
			System.out.println("role is null");
			return result;
		}

		if (role.getLevel() < 0) {
			System.out.println("role level is to low");
			return result;
		}

		// Get session to save user role and login:
		Map<String, Object> session = ActionContext.getContext().getSession();

		// Save user object in session:
		session.put("webshop_user", user);
		session.put("webshop_role_level", role.getLevel());
		session.put("message", "");
		firstname= user.getFirstname();
		lastname = user.getLastname();
		//TODO: role = user.getRole().getTyp();
		result = "success";

		return result;
	}
	
	@Override
	public void validate() {
		if (getUsername().length() == 0) {
			addActionError(getText("error.username.required"));
		}
		if (getPassword().length() == 0) {
			addActionError(getText("error.password.required"));
		}
	}

	public String getUsername() {
		return (this.username);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return (this.password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
