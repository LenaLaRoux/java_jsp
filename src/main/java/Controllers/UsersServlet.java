package Controllers;

import EntityGroups.ModelGroup;
import EntityGroups.UserGroup;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UsersServlet", urlPatterns = { "/Users" })
public class UsersServlet extends IndexServlet {
    @Override
    protected ModelGroup defineGroup (){
        return new UserGroup();
    }

    @Override
    protected String defineRequestUrl (){
        return "/Users";
    }

}
