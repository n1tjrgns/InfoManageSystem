package com.example.infomanage.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWordControllerTest {

    @Autowired
    private HelloWordController helloWordController; //controller bean 주입

    private MockMvc mockMvc;

    @Test
    void helloWorld() {
        System.out.println("test");
        System.out.println(helloWordController.helloWorld());

        Assertions.assertThat(helloWordController.helloWorld()).isEqualTo("HelloWorld");
    }

    @Test
    void mockMvcTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWordController).build(); //mockMvc 셋업

        //실질적인 수행
       mockMvc.perform(
               MockMvcRequestBuilders.get("/api/helloWorld") //http request
       ).andDo(MockMvcResultHandlers.print()) // request 정보 출력
       .andExpect(MockMvcResultMatchers.status().isOk()) // httpstatus 200 Ok 인지
       .andExpect(MockMvcResultMatchers.content().string("HelloWorld")); // response의 body 내용이 HelloWorld 인지
    }
}