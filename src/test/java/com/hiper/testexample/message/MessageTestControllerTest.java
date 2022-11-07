package com.hiper.testexample.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageTestController.class)
class MessageTestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageTestService service;


    @MockBean
    private MessageTestRepository repository;

    private ObjectMapper objectMapper;

    private MessageTestRequest dto;


    @Test
    void addMessage() throws  Exception{
        assertThat(service).isNotNull();
        dto = new MessageTestRequest();
        dto.setMessage("hola");
        mockMvc.perform(post("/message/add")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void getMessage() throws Exception {
        mockMvc.perform(get("/message/add")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        )
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void getMessageById() throws  Exception{
        mockMvc.perform(get("/message/add/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void updateMessage() throws Exception{
        mockMvc.perform(put("/message/add")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void deleteMessage() throws Exception{
        mockMvc.perform(delete("/message/add/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().is(HttpStatus.OK.value()));
    }
}