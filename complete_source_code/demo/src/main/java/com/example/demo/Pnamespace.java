package com.example.demo;

public class Pnamespace {
    private String first;
    private String second;
    private HelloRussia helloRussia;

    public HelloRussia getHelloRussia() {
        return helloRussia;
    }

    public void setHelloRussia(HelloRussia helloRussia) {
        this.helloRussia = helloRussia;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public void printAll(){
        System.out.println(first);
        System.out.println(second);
        helloRussia.sayHello();

    }
}
