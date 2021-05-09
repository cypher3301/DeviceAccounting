package com.example.demo.service;

import com.example.demo.converter.ItemConverter;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@Service
@AllArgsConstructor
public class ImplItemService implements ItemService{

    private final ItemRepository itemRepository;
    private final ItemConverter itemConverter;


    private void validateItemDto(ItemDto itemDto) throws ValidationException {
        if(isNull(itemDto))
            throw new ValidationException("Object is null");
        if(itemDto.getGosNumber()<0)
            throw new ValidationException("Gos number is invalid");
        if(itemDto.getAuditory()<0)
            throw new ValidationException("Auditory number is invalid");
    }
    @Override
    public ItemDto saveItem(ItemDto itemDto) throws ValidationException {
        validateItemDto(itemDto);
        Item saveItem = itemRepository.save(itemConverter.fromItemDtoToItem(itemDto));
        return itemConverter.fromItemToItemDto(saveItem);
    }

    @Override
    public void deleteItem(long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public ItemDto findByGosNumber(long gosNumber) {
        Item item = itemRepository.findByGosNumber(gosNumber);
        if (item!=null) return itemConverter.fromItemToItemDto(item);
        return null;
    }

    @Override
    public List<ItemDto> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(itemConverter::fromItemToItemDto)
                .collect(Collectors.toList());
    }
}
