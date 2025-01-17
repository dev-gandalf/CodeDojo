package soloproject.rakshith.newspaper.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import soloproject.rakshith.newspaper.Application;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
class NewspaperControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void when_goToIndex() throws Exception {
        mockMvc.perform(get("/index")).andExpect(status().isOk()).andExpect(view().name("index"));
    }


    @Test
    void when_details() throws Exception {
        mockMvc.perform(get("/details/{articleId}", "21")).andExpect(status().isOk()).andExpect(view().name("details"));
    }


}
