package Entities;

import java.util.HashMap;
import java.util.Map;

public enum Status implements IEnum
{
    active ("Активный"),
    closed ("Закрыт");

    private String title;

    Status(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    //****** Reverse Lookup Implementation************//

    //Lookup table
    private static final Map<String, Status> lookup = new HashMap<String, Status>();

    //Populate the lookup table on loading time
    static
    {
        for(Status env : Status.values())
        {
            lookup.put(env.name(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static Status get(String name)
    {
        return lookup.get(name);
    }

    @Override
    public Map<String, Status> getValues() {
        return lookup;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
