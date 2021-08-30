package org.alexandraavendano.printerstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.alexandraavendano.printerstore.models.Image;


public interface ImageRepository extends CrudRepository<Image, Long> {
}
