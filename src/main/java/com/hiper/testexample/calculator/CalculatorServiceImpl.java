package com.hiper.testexample.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public Double sum(Double valor1, Double valor2) {
        return valor1+valor2;
    }

    @Override
    public Double sub(Double valor1, Double valor2) {
        return valor1-valor2;
    }

    @Override
    public Double multi(Double valor1, Double valor2) {
        return valor1*valor2;
    }

    @Override
    public Double div(Double valor1, Double valor2) {

        if (valor2==0)
            throw new IllegalStateException("No se permite dividir por cero");

        return valor1/valor2;
    }
}
