package Controllers;

import Entities.EntityModel;
import EntityGroups.ModelGroup;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class IndexServlet extends HttpServlet {
    private ModelGroup group;
    abstract protected ModelGroup defineGroup();

    protected abstract String defineRequestUrl ();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modelIndex = request.getParameter("index");
        if (modelIndex != null){
            buildEditor(modelIndex, response);
        }else
            buildSelector(request, response);
    }

    private void buildSelector (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        group = defineGroup();
        group.read();

        request.setAttribute("titles", group.getColumnsFilter().getList());
        request.setAttribute("models", group.models());
        String urlAttr = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
        String url = urlAttr == null? "/" : "/"+urlAttr;
        getServletContext().getRequestDispatcher( defineRequestUrl ()).forward(request, response);
        //"/WEB-INF/views/Selector.jsp"
    }

    private void buildEditor (String modelIndex, HttpServletResponse response) throws IOException{
        EntityModel model = group.getById(Integer.valueOf(modelIndex));
        response.getWriter().print(model.toHtml());
    }
}
