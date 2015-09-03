package com.deswaef.shadowfury.item.repository;

import com.deswaef.shadowfury.infrastructure.repository.JpaRepository;
import com.deswaef.shadowfury.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
}
