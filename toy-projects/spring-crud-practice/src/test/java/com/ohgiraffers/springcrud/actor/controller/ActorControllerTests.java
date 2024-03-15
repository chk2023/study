package com.ohgiraffers.springcrud.actor.controller;

import com.ohgiraffers.springcrud.configuration.SpringCrudPracticeApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = { SpringCrudPracticeApplication.class })
public class ActorControllerTests {

    @Autowired
    private ActorController actorController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(actorController).build();
    }

    @Test
    public void 배우_전체_조회_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actor/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("actor/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void 배우_신규_등록_테스트() throws Exception {
        //given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("firstName", "형기");
        params.add("lastName", "홍");

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/actor/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/actor/list"))
                .andDo(MockMvcResultHandlers.print());
    }















}
