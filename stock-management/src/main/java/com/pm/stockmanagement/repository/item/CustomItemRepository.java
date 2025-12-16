package com.pm.stockmanagement.repository.item;


import com.pm.stockmanagement.entity.Item;
import com.pm.stockmanagement.service.dto.item.ItemFetchDto;

import java.util.List;

public interface CustomItemRepository {
    List<Item> filterItem(ItemFetchDto name);
}
