package com.example.demo.converter;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    public Item fromItemDtoToItem(ItemDto itemDto){
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setGosNumber(itemDto.getGosNumber());
        item.setAuditory(itemDto.getAuditory());
        item.setName(itemDto.getName());
        item.setType(itemDto.getType());
        item.setSimpleDescription(itemDto.getSimpleDescription());
        return item;
    }

    public ItemDto fromItemToItemDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .gosNumber(item.getGosNumber())
                .auditory(item.getAuditory())
                .name(item.getName())
                .type(item.getType())
                .simpleDescription(item.getSimpleDescription())
                .build();
    }
}
