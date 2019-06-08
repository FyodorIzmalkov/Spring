package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAnnotation {
    @Bean(name="helloWorld3")
    public HelloWorld createHelloWorld2(){
        return new HelloWorld();
    }
}
