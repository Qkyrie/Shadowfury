package com.deswaef.shadowfury.item.service;

import com.deswaef.shadowfury.item.model.Item;

import java.util.List;

public interface ItemService {
    long count();
    List<Item> findAll();
}
