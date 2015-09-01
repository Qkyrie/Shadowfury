package com.deswaef.shadowfury.wowhead;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * User: Quinten
 * Date: 23-12-13
 * Time: 13:05
 *
 * @author Quinten De Swaef
 */
public class WowheadConverter {
    private WowheadConverter(){}
    public static <T> T  convert(String input, Class<T> convertInto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(convertInto);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader reader = new StringReader(input);
        return (T) unmarshaller.unmarshal(reader);
    }
}
