package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    //http://localhost:8080/api/v1/calculator/add?n1=6.31&n2=7.57
    @GetMapping("/add")
    public Double add(@RequestParam("n1") Double n1, @RequestParam("n2") Double n2 ){
        return n1+n2;
    }

    //http://localhost:8080/api/v1/calculator/sub/7.57/6.31
    @GetMapping("/sub/{n1}/{n2}")
    public Double sub(@PathVariable("n1")Double n1, @PathVariable("n2")Double n2){
        Double result = null;
        if (n1 > n2) {
            result = n1 - n2;
        } else {
            result = n2 - n1;
        }
        return result;
    }

    //combination of requestparam and pathvarible
    //http://localhost:8080/api/v1/calculator/addition/10.8?n1=6.31&n2=7.57
    @GetMapping("/addition/{n3}")
    public Double addThree(@RequestParam("n1") Double n1, @RequestParam("n2") Double n2,
                           @PathVariable("n3") Double n3 ){
        return n1+n2+n3;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getN1() * calculatorDTO.getN2() * calculatorDTO.getN3() * calculatorDTO.getN4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
