package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ImageNotCreatedException;
import com.practicespring.printerstore.exceptions.ImageNotFoundException;
import com.practicespring.printerstore.models.*;
import com.practicespring.printerstore.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("")
    Image getClient(@RequestParam Long id) {
        return imageService.findBy(id).orElseThrow(() -> new ImageNotFoundException(id));
    }

    @PostMapping( "/create")
    Image getProducts(@RequestParam("images") MultipartFile files){
        Optional<Image> imageOptional = Optional.empty();

        try {
            imageOptional = Optional.of(imageService.create(files));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageOptional.orElseThrow(ImageNotCreatedException::new);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        imageService.delete(id);
    }
}
