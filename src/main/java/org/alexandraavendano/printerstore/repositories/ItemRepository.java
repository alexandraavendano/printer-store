package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
