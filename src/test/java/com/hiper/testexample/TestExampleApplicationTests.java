package com.hiper.testexample;

import com.hiper.testexample.message.MessageEntity;
import com.hiper.testexample.message.MessageRepository;
import com.hiper.testexample.message.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/*
@WebMvcTest(SendMailBatchController.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
 */
@SpringBootTest
class TestExampleApplicationTests {

    @Autowired
    private MessageService service;

    @MockBean
    private MessageRepository repository;

    @Mock
    MessageEntity entityMock;

    @Test
    void contextLoads() {
        /*
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        Double result = service.sum(valor1,valor2);
        assertEquals(10,result);
        */

        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertThat(service.getMessage()).isEmpty();
        verify(repository, times(1)).findAll();

        /*
  mockMvc.perform(post("/v1/send/email/batch/simple")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(requestSimpleEmail)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
         */
    }

}

