package com.hiper.testexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

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
    @Test
    void contextLoads() {
        TestExampleApplication.main(new String[]{});
        assertThat(mockMvc).isNotNull();
    }

}

