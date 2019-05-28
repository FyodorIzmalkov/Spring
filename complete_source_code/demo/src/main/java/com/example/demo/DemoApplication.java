package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");

        System.out.println(helloWorld.getHello()+ "\n");

        HelloRussia helloRussia = (HelloRussia) applicationContext.getBean("helloRussia");
        HelloIndia helloIndia = (HelloIndia) applicationContext.getBean("helloIndia");

        helloRussia.sayHello();
        helloIndia.sayHello();

        Five five = (Five) applicationContext.getBean("five");
        five.printAll();

    }

}
