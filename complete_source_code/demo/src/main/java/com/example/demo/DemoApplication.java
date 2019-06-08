package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.criteria.CriteriaBuilder;

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

        ConstructorArg constructorArg = (ConstructorArg) applicationContext.getBean("constructorArg");
        constructorArg.printAll();

        InnerBeanUsage innerBeanUsage = (InnerBeanUsage) applicationContext.getBean("innerBeanUsage");
        innerBeanUsage.printAll();
        System.out.println();

        System.out.println();
        AnnotationCall annotationCall = (AnnotationCall) applicationContext.getBean("annotationCall");
        annotationCall.setIntro("Hi, I am AnnotationCall!");
        annotationCall.printAll();

        System.out.println();
        AutowiredUsage autowiredUsage = (AutowiredUsage) applicationContext.getBean("autowiredUsage");
        autowiredUsage.printAll(helloWorld);

        System.out.println();
        ComponentTwo componentTwo = (ComponentTwo) applicationContext.getBean("componentDva");
        componentTwo.printAll();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAnnotation.class);
        HelloWorld helloWorld2 = context.getBean(HelloWorld.class);
        helloWorld2.setHello("Hello from AnnotationConfigACxt");
        System.out.println(helloWorld2.getHello());
    }

}
