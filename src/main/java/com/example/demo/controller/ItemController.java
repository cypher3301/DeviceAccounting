package com.example.demo.controller;


import com.example.demo.dto.ItemDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
@Log
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/save")
    public ItemDto saveItem(@RequestBody ItemDto itemDto) throws ValidationException {
        log.info("Handling save item: " + itemDto);
        return itemService.saveItem(itemDto);
    }

    @GetMapping("/findAll")
    public List<ItemDto> findAllItems(){
        log.info("Handling find all items request");
        return itemService.findAll();
    }

    @GetMapping("/findByGosNumber")
    public ItemDto findByGosNumber(@RequestParam long number){
        log.info("Handling find by gos number request: " + number);
        return itemService.findByGosNumber(number);
    }

    public ResponseEntity<Void> deleteItem(@PathVariable long id){
        log.info("Handling delete item request: "+id);
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }




}
