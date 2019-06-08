package com.example.demo;

public class HelloIndia {
    private String intro;
    private HelloWorld helloWorld;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void sayHello(){
        System.out.println(helloWorld.getHello());
        System.out.println(intro);
        System.out.println();
    }

    public void sayIntro(){
        System.out.println(intro);
    }
}
