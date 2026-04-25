package com.abishek.springbootapi;

import com.abishek.springbootapi.controller.TimeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTime() throws Exception {
        mockMvc.perform(get("/time"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.notNullValue()));
    }
}