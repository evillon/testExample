package com.hiper.testexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiper.testexample.message.MessageEntity;
import com.hiper.testexample.message.MessageRepository;
import com.hiper.testexample.message.MessageRequest;
import com.hiper.testexample.message.MessageServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
@WebMvcTest(SendMailBatchController.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
 */
@SpringBootTest
@AutoConfigureMockMvc
class TestExampleApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageServiceTest service;

    @MockBean
    private MessageRepository repository;

    private ObjectMapper objectMapper;

    private MessageRequest messageRequest;

    @Mock
    MessageEntity entityMock;

    @Test
    void contextLoads() throws Exception {
        assertThat(service).isNotNull();

        messageRequest = new MessageRequest();
        messageRequest.setMessage("hola");

        mockMvc.perform(post("/message")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(messageRequest)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

    }

}

