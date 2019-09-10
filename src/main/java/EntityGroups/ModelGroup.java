package EntityGroups;

import Entities.EntityModel;
import Entities.EntityModel;
import Utils.*;

import java.util.*;

public abstract class  ModelGroup  implements Iterable<EntityModel> {

    private Class entityClass;
    private List<? extends EntityModel> list = null;
    private Meta.GroupMeta meta;
    IServiceGroup service ;

    protected ModelGroup(Class entityClass){
        this.entityClass = entityClass;

        meta = new Meta().new GroupMeta(entityClass);

        service = new ServiceGroup(entityClass);
    }


    //method to override in children

//    public ModelGroup(Model [] m) {
//        list = Arrays.asList(m);
//    }

    /*public ModelGroup(List<? extends EntityModel> l) {
        list = l;
    }*/

    public Iterator<EntityModel> iterator() {
        return (Iterator<EntityModel>) list.iterator();
    }

    public List<? extends EntityModel> models (){
        return list;
    }

    public void read (){
        list = service.reread();
        if (list != null)
            list.forEach((x)-> x.setGroupModel(this) );
    }

    public void setColumnsFilter (Meta.ColumnsFilter filter){
        meta.setColumnFilter(filter);
    }
    public Meta.ColumnsFilter getColumnsFilter (){
        return meta.getColumnFilter();
    }

    public <T extends EntityModel> T getById (Integer id){
        T e = service.findById(id);
        e.setGroupModel(this);
        return e;
    }
}