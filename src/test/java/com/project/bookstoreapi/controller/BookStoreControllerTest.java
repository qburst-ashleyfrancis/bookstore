package com.project.bookstoreapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.service.BookStoreService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class BookStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BookStoreService service;

    @SpyBean
    BookStoreControllerTest controller;

    /**
     * Scenario 1 - add book details
     *
     * @throws Exception the file read/write exception
     */
    @Test
    void SaveBookTest_01() throws Exception {
        BookDetailsRequest request = new BookDetailsRequest();
        doNothing().when(service).save(request);
        ResultActions res = mockMvc.perform(post("/book/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)));
        res.andExpect(status().is(200));
    }


}
