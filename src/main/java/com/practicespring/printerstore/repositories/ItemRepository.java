package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
