package com.deswaef.shadowfury.wowhead.api.items.model;

import com.deswaef.shadowfury.wowhead.WowheadConverter;
import com.deswaef.shadowfury.wowhead.exception.WowHeadApiException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: Quinten
 * Date: 23-12-13
 * Time: 13:01
 *
 * @author Quinten De Swaef
 */
@XmlRootElement(name = "wowhead")
public class WowHeadItemDto {

    @XmlElement(name = "item")
    private WowHeadInnerItem item;

    public WowHeadInnerItem getItem() {
        return item;
    }

    public static WowHeadItemDto fromXml(String input) throws WowHeadApiException {
        if (input != null && !input.isEmpty()) {
            try {
                WowHeadItemDto convert = WowheadConverter.convert(input, WowHeadItemDto.class);
                if (convert == null) {
                    throw new WowHeadApiException("unable to convert " + input);
                }
                return convert;
            } catch (JAXBException e) {
                throw new WowHeadApiException("unable to convert " + input, e);
            }
        } else {
            throw new WowHeadApiException("input from wowhead was empty");
        }
    }
}