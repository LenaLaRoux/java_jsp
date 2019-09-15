package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersRefServlet" , urlPatterns = { "/RefUsers" })
public class UsersRefServlet extends UsersServlet {
    @Override
    protected String defineRequestUrl (){
        return "/WEB-INF/views/Selector.jsp";
    }
}
