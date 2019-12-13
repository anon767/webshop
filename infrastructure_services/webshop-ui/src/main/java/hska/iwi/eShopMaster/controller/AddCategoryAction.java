package hska.iwi.eShopMaster.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hska.iwi.eShopMaster.model.Category;
import hska.iwi.eShopMaster.model.User;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.CategoryManagerImpl;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.ProductManagerImpl;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.UserManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class AddCategoryAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -6704600867133294378L;

    private String newCatName = null;

    private List<Category> categories;

    @Autowired
    private CategoryManagerImpl categoryManager;

    @Autowired
    private UserManagerImpl userManager;

    @Autowired
    private ProductManagerImpl productManager;

    User user;

    public String execute() throws Exception {

        String res = "input";

        Map<String, Object> session = ActionContext.getContext().getSession();
        user = (User) session.get("webshop_user");
        /**
         if (user != null && (user.getRole().getTyp().equals("admin"))) {
         CategoryManager categoryManager = new CategoryManagerImpl();
         // Add category
         categoryManager.addCategory(newCatName);

         // Go and get new Category list
         this.setCategories(categoryManager.getCategories());

         res = "success";
         }
         **/
        return res;

    }

    @Override
    public void validate() {
        if (getNewCatName().length() == 0) {
            addActionError(getText("error.catname.required"));
        }
        // Go and get new Category list
        this.setCategories(categoryManager.getCategories());
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getNewCatName() {
        return newCatName;
    }

    public void setNewCatName(String newCatName) {
        this.newCatName = newCatName;
    }
}
