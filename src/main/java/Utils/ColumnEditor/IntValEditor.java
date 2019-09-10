package Utils.ColumnEditor;

public class IntValEditor extends ColumnEditor{
    private Integer intVal;

    public IntValEditor (Integer intVal, String name, String title, boolean isRequired){
        super(name, title, isRequired);
        this.intVal = intVal;
    }
    @Override
    public String toString() {
        if (intVal == null)
            return "";

        return intVal.toString();
    }
    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append("<input type=\"number\" ");
        sb.append("id=\""+fieldId + "\"");
        if (isRequired)
            sb.append(" required ");

        if (this.intVal != null)
            sb.append(" value=\""+this.toString()+ "\"");
        sb.append(">");
        sb.append("</div>");
        return sb.toString();
    }
}
