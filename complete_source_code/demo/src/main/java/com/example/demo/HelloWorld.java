package com.example.demo;

public class HelloWorld {
    private String hello;

    public String getHello() {
        return hello;
    }

    public void initializeHelloWorld(){
        System.out.println("initializeHelloWorld() from HelloWorld bean");
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
