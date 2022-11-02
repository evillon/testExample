package com.hiper.testexample.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(CalculatorServiceImpl.class)
@ExtendWith(SpringExtension.class)
class CalculatorServiceImplTest {

    @Autowired
    private CalculatorService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sum() {
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        Double result = service.sum(valor1,valor2);
        assertEquals(10,result);
    }

    @Test
    void sub() {
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        Double result = service.sub(valor1,valor2);
        assertEquals(0,result);
    }

    @Test
    void multi() {
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        Double result = service.multi(valor1,valor2);
        assertEquals(25,result);
    }

    @Test
    void div() {
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        Double result = service.div(valor1,valor2);
        assertEquals(1,result);
    }

    @Test
    void divPorCero(){
        Double valor1 = 5.0;
        Double valor2 = 0.0;

        //assertEquals(1,result);
        assertThrows(IllegalStateException.class,()->service.div(valor1,valor2));
    }

}