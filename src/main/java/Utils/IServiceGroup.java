package Utils;

import Entities.EntityModel;

import java.util.List;

public interface IServiceGroup extends IService{
    public <T  extends EntityModel> T findById(int id) ;
    public <T extends EntityModel> List<T> reread();
}
