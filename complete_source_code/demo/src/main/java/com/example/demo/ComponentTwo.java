package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("componentDva")
public class ComponentTwo {
    @Value("Odin")
    private String odin;
    @Value("Dva")
    private String dva;

    public void printAll(){
        System.out.println(odin);
        System.out.println(dva);
    }
}
