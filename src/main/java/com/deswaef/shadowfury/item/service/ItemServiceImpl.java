package com.deswaef.shadowfury.item.service;

import com.deswaef.shadowfury.item.model.Item;
import com.deswaef.shadowfury.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public long count() {
        return itemRepository.count();
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

}
