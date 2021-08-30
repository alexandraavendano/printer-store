package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.exceptions.ImageNotCreatedException;
import org.alexandraavendano.printerstore.exceptions.ImageNotFoundException;
import org.alexandraavendano.printerstore.models.Image;
import org.alexandraavendano.printerstore.service.impl.ImageServices;
import org.alexandraavendano.printerstore.service.ImageServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/images")
public class ImageController {

    private final ImageServicesI imageServices;

    @Autowired
    public ImageController(ImageServices imageServices){
        this.imageServices = imageServices;
    }

    @GetMapping("")
    Image getImage(@RequestParam Long id) {
        return imageServices.findBy(id).orElseThrow(() -> new ImageNotFoundException(id));
    }

    @PostMapping( "")
    Image saveImage(@RequestParam("images") MultipartFile files){
        Optional<Image> imageOptional = Optional.empty();

        try {
            imageOptional = Optional.of(imageServices.create(files));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageOptional.orElseThrow(ImageNotCreatedException::new);
    }
}
