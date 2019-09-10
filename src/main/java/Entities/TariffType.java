package Entities;

import java.util.HashMap;
import java.util.Map;

public enum TariffType implements IEnum
{
    bysquare ("By square"),
    byyear ("By year"),
    bytype ("By property type");

    private String title;

    TariffType(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    //****** Reverse Lookup Implementation************//

    //Lookup table
    private static final Map<String, TariffType> lookupByName = new HashMap<String, TariffType>();

    //Populate the lookup table on loading time
    static
    {
        for(TariffType env : TariffType.values())
        {
            lookupByName.put(env.name(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static TariffType get(String name)
    {
        return lookupByName.get(name);
    }

    @Override
    public Map<String, TariffType> getValues() {
        return lookupByName;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
