package com.deswaef.shadowfury.wowhead;

import com.deswaef.shadowfury.wowhead.exception.WowHeadApiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * User: Quinten
 * Date: 23-12-13
 * Time: 13:54
 *
 * @author Quinten De Swaef
 */
@Component
public class WowheadAPIClient {

    private Log logger = LogFactory.getLog(this.getClass());

    private @Value("${wowhead.api.baseurl}") String wowheadRootPath;

    public final String getWowheadRootPath() {
        return wowheadRootPath;
    }

    public String getFromWowheadAPI (String apiUrl) throws WowHeadApiException {
        RestTemplate template = new RestTemplate();
        String result;
        try {
            result = template.getForObject(wowheadRootPath + apiUrl, String.class);
        }
        catch(Exception ex){
            logger.error(ex.getMessage());
            throw new WowHeadApiException(String.format("Error during the fetch of %s%s", wowheadRootPath, apiUrl), ex);
        }
        return result;
    }

}
