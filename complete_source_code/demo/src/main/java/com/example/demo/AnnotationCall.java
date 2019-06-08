package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AnnotationCall {
    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void printAll(){
        System.out.println(intro);
    }
}
