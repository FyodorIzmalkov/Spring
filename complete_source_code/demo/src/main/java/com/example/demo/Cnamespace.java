package com.example.demo;

public class Cnamespace {

    private String one;
    private String two;
    private String three;

    public Cnamespace(String one, String two, String three){
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public void printAll(){
        System.out.println();
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println();
    }
}
