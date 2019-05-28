package com.example.demo;

public class Five extends Three{
    private String four;
    private String five;

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public void printAll(){
        String result;
        result = this.getOne();
        result = result + this.getTwo() + this.getThree() + this.getFour() + this.getFive();
        System.out.println("\n" + result);
    }
}
