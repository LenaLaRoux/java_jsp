package Utils.ColumnEditor;

public class DoubValEditor extends ColumnEditor {
    private Double dec;

    public DoubValEditor (Double d, String name, String title, boolean isRequired){
        super(name, title, isRequired);
        this.dec = d;
    }

    @Override
    public String toString(){
        if(dec == null){
            return "";
        }
        return String.format("%.2f", dec);
    }

    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append("<input type=\"number\" min=\"0\" placeholder=\"<not defined>\"");
        sb.append(" id=\""+fieldId + "\"");
        if (isRequired)
            sb.append(" required ");

        if (this.dec != null)
            sb.append(" value=\""+this.toString()+ "\"");
        sb.append(">");
        sb.append("</div>");
        return sb.toString();
    }
}
