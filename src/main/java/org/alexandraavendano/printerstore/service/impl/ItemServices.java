package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Item;
import org.alexandraavendano.printerstore.repositories.ItemRepository;
import org.alexandraavendano.printerstore.service.ItemServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServices implements ItemServicesI {

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
