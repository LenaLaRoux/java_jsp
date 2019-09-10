package Utils.ColumnEditor;

import Entities.IEnum;
import java.util.Map;

public class EnumValEditor extends ColumnEditor {
    private IEnum enumeration;

    public EnumValEditor (IEnum e, String name, String title, boolean isRequired){
        super(name, title, isRequired);
        this.enumeration =e;
    }

    @Override
    public String toString (){
        if (enumeration == null)
            return "";
        return enumeration.getTitle();
    }

    @Override
    protected String getValueEditor() {
        String currentValue = enumeration!= null? enumeration.getValue() : null;

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append(" <select id=\"" + fieldId + "\"" +(isRequired? " required":"") + " placeholder=\"<not defined>\">");

        Map<String, ? extends IEnum> vals = enumeration.getValues();
        vals.forEach( (key, value)->{
            sb.append(" <option ");
            sb.append("value=\""+key+"\"");
            if (currentValue != null && currentValue ==key)
                sb.append(" selected ");
            sb.append(">");
            sb.append(value.getTitle());
            sb.append("</option>");
        });

        sb.append(" </select>");
        sb.append("</div>");
        return sb.toString();
    }
}
