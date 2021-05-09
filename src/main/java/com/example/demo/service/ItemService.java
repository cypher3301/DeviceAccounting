package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface ItemService {

    ItemDto saveItem(ItemDto itemDto) throws ValidationException;

    void deleteItem(long itemId);

    ItemDto findByGosNumber(long gosNumber);

    List<ItemDto> findAll();
}
