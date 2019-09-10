package Utils.ColumnEditor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeValEditor extends ColumnEditor{
    private Date time ;

    public TimeValEditor (Timestamp timeVal, String name, String title, boolean isRequired){
        super(name, title, isRequired);
        this.time = timeVal;
    }

    @Override
    public String toString() {
        if (time == null)
            return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(time);
    }

    @Override
    protected String getValueEditor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"value-editor\">");
        sb.append("<input type=\"datetime-local\" placeholder=\"<not defined>\""); //"2017-06-01T08:30"
        sb.append("id=\""+fieldId + "\"");
        if (isRequired)
            sb.append(" required ");

        if (this.time != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append(" value=\"" + dateFormat.format(this.time).replace(" ","T") + "\"");
        }
        sb.append(">");
        sb.append("</div>");
        return sb.toString();
    }
}
