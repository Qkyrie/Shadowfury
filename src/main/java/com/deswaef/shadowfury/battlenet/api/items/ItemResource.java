package com.deswaef.shadowfury.battlenet.api.items;

import com.deswaef.shadowfury.battlenet.api.items.model.Item;
import retrofit.RestAdapter;

public class ItemResource {
    private ItemService itemService;

    public Item item(long id) {
        return itemService.item(id);
    }

    public ItemResource url(RestAdapter restAdapter) {
        this.itemService = restAdapter.create(ItemService.class);
        return this;
    }
}
