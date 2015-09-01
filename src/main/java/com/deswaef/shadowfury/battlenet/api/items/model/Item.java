package com.deswaef.shadowfury.battlenet.api.items.model;

/**
 * only went for the basic stuff, I don't really need the rest
 */
public class Item {
    private long id;
    private String description;
    private String name;
    private String icon;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
