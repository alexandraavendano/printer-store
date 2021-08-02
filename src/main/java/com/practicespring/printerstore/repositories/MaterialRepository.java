package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, Integer> {
}
