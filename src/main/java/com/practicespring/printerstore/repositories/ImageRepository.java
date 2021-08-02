package com.practicespring.printerstore.repositories;

import org.springframework.data.repository.CrudRepository;
import com.practicespring.printerstore.models.Image;


public interface ImageRepository extends CrudRepository<Image, Long> {
}
