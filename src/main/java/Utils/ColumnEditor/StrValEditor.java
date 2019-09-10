package Utils.ColumnEditor;

public class StrValEditor extends ColumnEditor {
    private String strVal;

    public StrValEditor(String strVal, String name, String title, boolean isRequired) {
        super(name, title, isRequired);
        this.strVal = strVal;
    }

    @Override
    public String toString() {
        return strVal == null ? "" : strVal;
    }
    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append("<input type=\"text\" placeholder=\"<not defined>\"");
        sb.append("id=\""+fieldId+"\"");
        if (isRequired)
            sb.append(" required ");
        if (strVal !=null)
            sb.append(" value=\""+this.toString().trim()+ "\"");
        sb.append(">");
        sb.append("</div>");
        return sb.toString();
    }
}
