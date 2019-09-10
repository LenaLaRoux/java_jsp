package Utils.ColumnEditor;

abstract public class ColumnEditor {
    public boolean isRequired;
    public String fieldId;
    public String title;

    public ColumnEditor(String name, String title, boolean isRequired){
        this.isRequired = isRequired;
        this.fieldId = name;
        this.title = title;
    }
    public String toHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append(" <div class=\"property-field\"> ");
        sb.append("<label for=\"");
        sb.append(this.fieldId);
        sb.append("\">");
        sb.append(this.title+":");
        if (isRequired){
            sb.append(" <em>*</em>");
        }
        sb.append("</label>");
        sb.append(getValueEditor());
        sb.append("</div>");

        return sb.toString();
    }
    protected abstract String getValueEditor();

}
