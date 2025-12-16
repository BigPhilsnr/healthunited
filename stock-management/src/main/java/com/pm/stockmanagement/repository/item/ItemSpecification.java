package com.pm.stockmanagement.service;

import com.pm.stockmanagement.entity.Item;
import com.pm.stockmanagement.service.dto.item.ItemFetchDto;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {
    public static Specification<Item> filter(ItemFetchDto itemFetchDto) {
        return Specification.where(name(itemFetchDto.getName()));
    }

    private static Specification<Item> name(String name) {
        return (root, query, cb) -> cb.equal(root.get("name"), name);
    }
}
