package com.pm.stockmanagement.repository.item;

import com.pm.stockmanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository  extends JpaRepository<Item, UUID>, JpaSpecificationExecutor<Item>, CustomItemRepository {

}
