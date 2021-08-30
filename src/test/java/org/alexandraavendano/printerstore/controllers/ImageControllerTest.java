package org.alexandraavendano.printerstore.controllers;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageControllerTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext wContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wContext)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    @Test
    public void firstUploadWordsTest() throws Exception {
        String text ="Text to be uploaded.";
        MockMultipartFile file = new MockMultipartFile("file","test.txt", "text/plain", text.getBytes());
        mockMvc.perform(MockMvcRequestBuilders.multipart("/images")
                        .file(file)
                        .characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
