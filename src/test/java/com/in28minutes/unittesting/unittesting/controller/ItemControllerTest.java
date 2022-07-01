package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.model.*;
import com.in28minutes.unittesting.unittesting.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BusinessService businessService;
    @Test
    public void dummy_basic_api() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request).andExpect(status().is2xxSuccessful()).andExpect(content().json(
                "{id: 1,name: ball,price:10,quantity: 100}")).andReturn();

    }
    @Test
    public void itemFromBusinessService() throws Exception {
        when(businessService.retrieveHardcodedItemFromBusinessService(1,"ball",10,100)).thenReturn(new Item(1,"ball",10,100));
        RequestBuilder request= MockMvcRequestBuilders.get("/get-item-from-business-service").accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request).andExpect(status().is2xxSuccessful()).andExpect(content().json(
                "{id: 1,name: ball,price:10,quantity: 100}")).andReturn();
//        when(businessService.retrieveHardcodedItemFromBusinessService(1,"ball",10,100)).thenReturn(new Item(1,"ball",10,100));

    }

}