package Utils.ColumnEditor;

import Entities.IEntity;

public class RefValEditor extends ColumnEditor {
    IEntity entity;
    public RefValEditor(IEntity entity, String name, String title, boolean isRequired){
        super(name, title, isRequired);
        this.entity = entity;
    }

    @Override
    public String toString() {
        if(entity == null)
            return "";
        return entity.calcTitle();
    }

    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"ref-editor\">");
        sb.append("<input class=\"ref title\" type=\"text\" placeholder=\"<not defined>\" readonly");
        sb.append("id=\""+fieldId+"\"");
        if (isRequired)
            sb.append(" required ");
        if (this.entity != null)
            sb.append(" value=\""+this.toString()+ "\"");
        sb.append(">");
        sb.append("<input class=\"ref button\" type=\"button\" value=\"...\" onclick=\"showSelector()\"");
        sb.append("</div>");
        return sb.toString();
    }
}
