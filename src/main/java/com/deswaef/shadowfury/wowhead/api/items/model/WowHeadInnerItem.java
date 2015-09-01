package com.deswaef.shadowfury.wowhead.api.items.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * User: Quinten
 * Date: 23-12-13
 * Time: 13:39
 *
 * @author Quinten De Swaef
 */
public class WowHeadInnerItem {

    @XmlElement(name = "level")
    private int level;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "quality")
    private String quality;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getQuality() {
        return quality;
    }
}