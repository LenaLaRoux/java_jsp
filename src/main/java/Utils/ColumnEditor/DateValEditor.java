package Utils.ColumnEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValEditor extends ColumnEditor{
    private  Date date ;

    public DateValEditor (Date dateVal, String name, String title, boolean isRequired)    {
        super(name, title, isRequired);
        this.date = dateVal;
    }

    @Override
    public String toString() {
        if (date == null)
            return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append("<input type=\"date\" placeholder=\"<not defined>\"");
        sb.append("id=\""+this.fieldId + "\"");
        if (isRequired)
            sb.append(" required ");
        if (this.date != null)
            sb.append(" value=\""+this.toString()+ "\"");
        sb.append(">");
        sb.append("</div>");
        return sb.toString();
    }
}
