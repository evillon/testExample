package com.hiper.testexample.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        assertThat(service).isNotNull();
    }

    @Test
    void sum() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/sumar?valor1=2&valor2=3"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void sub() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/restar?valor1=2&valor2=3"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void multi() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/multiplicar?valor1=2&valor2=3"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void div() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/dividir?valor1=2&valor2=3"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }


}