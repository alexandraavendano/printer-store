package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Image;
import com.practicespring.printerstore.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImageService {

    public final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    public Image create(MultipartFile file) throws IOException {
        String originalFileName;
        Image image = new Image();

        originalFileName = Objects.requireNonNull(file.getOriginalFilename(), "Please select at least one file.");
        if (!originalFileName.isEmpty()) {
            image.setName(file.getOriginalFilename());
            image.setContent(Base64.getEncoder().encodeToString(file.getBytes()));
            return imageRepository.save(image);
        }

        return imageRepository.save(image);
    }

    public Iterable<Image> getAll() {
        return imageRepository.findAll();
    }

    public Optional<Image> findBy(Long id) {
        return imageRepository.findById(id);
    }

    public void delete(Long id) {
        imageRepository.deleteById(id);
    }
}
