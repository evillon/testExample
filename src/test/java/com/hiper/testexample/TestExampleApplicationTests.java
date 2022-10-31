package com.hiper.testexample;

import com.hiper.testexample.calculator.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestExampleApplicationTests {

    @Autowired
    private CalculatorService service;


    @Test
    void contextLoads() {
        //given
        Double valor1 = 5.0;
        Double valor2 = 5.0;
        //execute
        Double result = service.sum(valor1,valor2);
        //espected
        assertEquals(10.0,result);
    }

}
