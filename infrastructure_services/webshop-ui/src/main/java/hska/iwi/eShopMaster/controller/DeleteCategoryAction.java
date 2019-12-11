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
public class DeleteCategoryAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1254575994729199914L;
    @Autowired
    private CategoryManagerImpl categoryManager;

    @Autowired
    private UserManagerImpl userManager;

    @Autowired
    private ProductManagerImpl productManager;
    private int catId;
    private List<Category> categories;

    public String execute() throws Exception {

        String res = "input";

        Map<String, Object> session = ActionContext.getContext().getSession();
        User user = (User) session.get("webshop_user");
        /** TODO:
         if(user != null && (user.getRole().getTyp().equals("admin"))) {

         // Helper inserts new Category in DB:
         CategoryManager categoryManager = new CategoryManagerImpl();

         categoryManager.delCategoryById(catId);

         categories = categoryManager.getCategories();

         res = "success";

         }**/

        return res;

    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
