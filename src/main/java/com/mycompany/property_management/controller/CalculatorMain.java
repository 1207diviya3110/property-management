package com.mycompany.property_management.controller;

public class CalculatorMain {
    public static void main(String[] args){
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(3.1, 6.0);
        System.out.println(result);
    }
}
