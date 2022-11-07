package com.hiper.testexample.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {


    private final CalculatorService service;

    @Autowired
    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @PostMapping(value = "/sumar")
    @ResponseBody
    public Double sum(@RequestParam Double valor1,
                      @RequestParam Double valor2){
        return service.sum(valor1,valor2);
    }

    @PostMapping(value = "/restar")
    @ResponseBody
    public Double sub(@RequestParam Double valor1,
                      @RequestParam Double valor2){
        return service.sub(valor1,valor2);
    }

    @PostMapping(value = "/multiplicar")
    @ResponseBody
    public Double multi(@RequestParam Double valor1,
                      @RequestParam Double valor2){
        return service.multi(valor1,valor2);
    }

    @PostMapping(value = "/dividir")
    @ResponseBody
    public Double div(@RequestParam Double valor1,
                      @RequestParam Double valor2){
        return service.div(valor1,valor2);
    }

}
