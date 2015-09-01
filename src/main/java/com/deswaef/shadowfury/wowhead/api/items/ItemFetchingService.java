package com.deswaef.shadowfury.wowhead.api.items;

import com.deswaef.shadowfury.wowhead.WowheadAPIClient;
import com.deswaef.shadowfury.wowhead.api.items.model.WowHeadItemDto;
import com.deswaef.shadowfury.wowhead.exception.WowHeadApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemFetchingService {

    @Autowired
    private WowheadAPIClient apiClient;

    /**
     * throw an exception if the item is not found [unparsable or just fail
     * ]
     * @param itemId
     * @return
     * @throws WowHeadApiException
     */
    public WowHeadItemDto getItem(Long itemId) throws WowHeadApiException {
        StringBuilder builder = new StringBuilder("/item=")
                .append(itemId)
                .append("&xml");
        return WowHeadItemDto.fromXml(apiClient.getFromWowheadAPI(builder.toString()));
    }


}
