package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import javax.annotation.security.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)

class HelloWorldControllerTest {
   @Autowired
    private MockMvc mockMvc;
   @Test
public void test_api() throws Exception {
    RequestBuilder request= MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
    MvcResult result=mockMvc.perform(request).andExpect(status().is2xxSuccessful())
       .andReturn();
    assertEquals("hello world",result.getResponse().getContentAsString());


}
}