package com.pm.stockmanagement.repository.itemgroup;

import com.pm.stockmanagement.entity.ItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemGroupRepository extends JpaRepository<ItemGroup, UUID> {
}
