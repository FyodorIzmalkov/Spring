package com.example.demo;

public class ConstructorArg {
    private int number;
    private long longNumber;
    private boolean bool;

    public ConstructorArg(int number, long longNumber, boolean bool){
        this.number = number;
        this.longNumber = longNumber;
        this.bool = bool;
    }

    public void printAll(){
        System.out.println("Number is: " + number);
        System.out.println("Long is: " + longNumber);
        System.out.println("Boolean is: " + bool);
    }
}
