package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutowiredUsage {

    @Autowired
    private HelloWorld helloWorld;
    private HelloIndia helloIndia;

    @Autowired
    @Qualifier("componentOdin")
    private ComponentOne componentOne;

    @Autowired
    public AutowiredUsage(HelloIndia helloIndia){
        this.helloIndia = helloIndia;
    }

    @Autowired
    public void printAll(HelloWorld helloWorld){
        this.helloWorld.setHello("Hello from Autowired Usage");
        System.out.println(this.helloWorld.getHello());
        helloIndia.setIntro("Hello from Autowired India");
        helloIndia.sayIntro();

        System.out.println(helloWorld.getHello());
        componentOne.printAll();
    }

}
