package Entities;

import java.util.Map;

public interface IEnum {
    public String getTitle();
    public String getValue();
    public Map<String, ? extends IEnum> getValues();
}
