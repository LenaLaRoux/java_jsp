package Controllers;

import EntityGroups.ContractGroup;
import EntityGroups.ModelGroup;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ContractsServlet", urlPatterns = { "/","/Contracts"})
public class ContractsServlet extends IndexServlet {
    @Override
    protected ModelGroup defineGroup (){
        return new ContractGroup();
    }

    @Override
    protected String defineRequestUrl (){
        return "/";
    }

}
