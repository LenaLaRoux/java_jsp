package Entities;

import EntityGroups.ModelGroup;
import Utils.IEntityService;
import Utils.IService;
import Utils.Meta;
import Utils.Service;

import java.io.Serializable;
import java.util.List;

public abstract class EntityModel implements Serializable, IEntity {
    //IService - CRUD operations
    protected IEntityService service = new Service(this);
    private ModelGroup groupModel = null;
    //Table metadata
    private Meta.EntityMeta meta = new Meta().new EntityMeta (this);

    public Meta.EntityMeta getMeta (){
        return meta;
    }
    public String calcTitle(){
        return "";
    }

    public void setGroupModel(ModelGroup groupModel) {
        this.groupModel = groupModel;
    }
    public ModelGroup getGroupModel (){
        return this.groupModel;
    }
    //meta delegates
    public void filterColumns(Meta.ColumnsFilter columnsFilter){
        this.getMeta().setColumnFilter(columnsFilter);
    }
    public List<Meta.Column> getSelectorColumns(){
        return this.getMeta().selectorColumns().getList();
    }
    public List<Meta.Column> getEditorColumns(){
        return this.getMeta().editorColumns().getList();
    }
    //service delegates
    public void save(){
        service.save();
    }
    public void update(){
        service.update();
    }
    public void delete(){
        service.delete();
    }

    public String toHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"standard-editor\">");
        sb.append("<form id=\"frmId\">");
        sb.append("<fieldset form=\"frmId\">");
        sb.append("<legend>"+this.calcTitle()+"</legend>");
        sb.append("<div class=\"prop-wrapper\">");

        for (Meta.Column col : this.getEditorColumns()){
            sb.append(col.toHtml());
        }
        sb.append(" </div>");
        sb.append(" </fieldset>");

        sb.append("</form>");
        sb.append("<button onclick=\"popUpClose()\" id='close-button'>Close</button>");
        sb.append("</div>");

        return sb.toString();
    }

}
