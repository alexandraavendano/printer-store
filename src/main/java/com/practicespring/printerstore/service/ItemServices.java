package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Item;
import com.practicespring.printerstore.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServices {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServices( ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
