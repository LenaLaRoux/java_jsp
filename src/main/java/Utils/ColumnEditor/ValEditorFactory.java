package Utils.ColumnEditor;

import Entities.IEntity;
import Entities.IEnum;
import Utils.Meta;
import java.sql.Timestamp;
import java.util.Date;

public class ValEditorFactory {
    public static ColumnEditor getInstance (Meta.Column column){

        final Class valType = column.getValType();
        final Object val = column.getValue();
        final boolean isRequired = column.isRequired();
        final String fieldName = column.getName();
        final String title = column.getTitle();

        if (IEntity.class.isAssignableFrom(valType)){
            return new RefValEditor((IEntity) val, fieldName, title, isRequired);
        }else if(Integer.class.isAssignableFrom(valType) || int.class.equals(valType)){
            return new IntValEditor((Integer) val, fieldName, title, isRequired);
        }else if (Timestamp.class.isAssignableFrom(valType)){
            return new TimeValEditor ((Timestamp) val, fieldName, title, isRequired);
        }else if (Date.class.isAssignableFrom(valType)){
            return new DateValEditor((Date) val, fieldName, title, isRequired);
        }else if (Enum.class.isAssignableFrom(valType)){
            return new EnumValEditor((IEnum) val, fieldName, title, isRequired);
        }else if (Double.class.isAssignableFrom(valType) || double.class.equals(valType)){
            return new DoubValEditor((Double) val, fieldName, title, isRequired);
        }else
            return new StrValEditor ((String) val, fieldName, title, isRequired);
    }
}

