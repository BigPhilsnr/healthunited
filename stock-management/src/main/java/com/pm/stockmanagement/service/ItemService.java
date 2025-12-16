package com.pm.stockmanagement.service;

import com.pm.stockmanagement.entity.Item;
import com.pm.stockmanagement.repository.item.ItemRepository;
import com.pm.stockmanagement.repository.item.ItemSpecification;
import com.pm.stockmanagement.service.dto.item.ItemFetchDto;
import com.pm.stockmanagement.service.dto.item.ItemRequestDto;
import com.pm.stockmanagement.service.dto.item.ItemResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public Page<Item> findAll(ItemFetchDto itemFetchDto, Pageable pageable) {
         return itemRepository.findAll(ItemSpecification.filter(itemFetchDto), pageable);
    }

    @Transactional(readOnly = true)
    public ItemResponseDto getItemById(UUID id) {
       Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("item not found"));
       ItemResponseDto itemResponseDto = new ItemResponseDto();
       itemResponseDto.setId(String.valueOf(item.getId()));
       return itemResponseDto;
    }

    @Transactional
    public ItemResponseDto saveItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setTitle(itemRequestDto.getTitle());
        item.setDescription(itemRequestDto.getDescription());
       Item response =  itemRepository.save(item);

       ItemResponseDto itemResponseDto = new ItemResponseDto();
       itemResponseDto.setId(String.valueOf(response.getId()));
       itemResponseDto.setTitle(response.getTitle());
       itemResponseDto.setDescription(response.getDescription());

       return  itemResponseDto;
    }
}
