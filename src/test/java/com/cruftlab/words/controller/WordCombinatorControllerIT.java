package com.cruftlab.words.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordCombinatorControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTwoCombinedWords() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/words/combined/random/2/").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getOneCombinedWordWithSpecifiedWordShouldBeOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/words/combined/randomWith/1/sevje").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFiveCombinedWordsWithSpecifiedWordShouldFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/words/combined/randomWith/5/fewetasf2q").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
