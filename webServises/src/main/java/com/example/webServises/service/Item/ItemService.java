package com.example.webServises.service.Item;

import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto Create(ItemDto itemDto);
    List<ItemDto> getAll();
    ItemDto getById(String id);
    ItemDto update(ItemDto itemDto,String id);
    void deleteById(String id);
}
