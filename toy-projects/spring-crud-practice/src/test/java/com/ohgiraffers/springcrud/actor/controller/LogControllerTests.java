package com.ohgiraffers.springcrud.actor.controller;

import com.ohgiraffers.springcrud.configuration.SpringCrudPracticeApplication;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ContextConfiguration(classes = { SpringCrudPracticeApplication.class })
public class LogControllerTests {

    @Autowired
    private LogController logController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(logController).build();
    }

    @Test
    public void 로그_파일_조회_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/log"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("logs"))
                .andDo(MockMvcResultHandlers.print());
    }



}
