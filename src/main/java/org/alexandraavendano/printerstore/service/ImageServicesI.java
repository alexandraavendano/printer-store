package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface ImageServicesI {

    Image create(MultipartFile file) throws IOException;

    Optional<Image> findBy(Long id);

    void delete(Long id);
}