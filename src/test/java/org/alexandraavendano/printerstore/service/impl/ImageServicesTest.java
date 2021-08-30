package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageServicesTest {
    @Autowired
    private ImageServices imageServices;

    @Test
    public void saveMultipartFile() throws IOException {
        FileInputStream inputFile = new FileInputStream( "src/test/resources/image/banner.jpeg");
        MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);
        Image expectedImage = imageServices.create(file);
        Image actualImage = imageServices.findBy(expectedImage.getId()).get();

        assertEquals(expectedImage, actualImage);
    }
}
