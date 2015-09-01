package com.deswaef.shadowfury.battlenet.api.items;

import com.deswaef.shadowfury.battlenet.api.items.model.Item;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by QuintenDes on 31/08/15.
 */
public interface ItemService {

    @GET("/wow/item/{id}")
    Item item(@Path("id")long id);
}
