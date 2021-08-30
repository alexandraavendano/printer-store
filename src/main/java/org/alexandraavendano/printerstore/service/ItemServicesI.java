package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Item;

import java.util.Optional;

public interface ItemServicesI {

    Optional<Item> getById(Long id);

    Item save(Item item);
}
