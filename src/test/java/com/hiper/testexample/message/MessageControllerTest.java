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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MessageController.class)
class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageServiceTest service;

    private ObjectMapper objectMapper;

    private MessageRequest dto;


    @Test
    void addMessage() throws  Exception{
        assertThat(service).isNotNull();
        dto = new MessageRequest();
        dto.setMessage("hola");
        mockMvc.perform(post("/message/add")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    void getMessage() {
    }

    @Test
    void getMessageById() {
    }

    @Test
    void updateMessage() {
    }

    @Test
    void deleteMessage() {
    }
}