package com.example.demo;

public class InnerBeanUsage {
    private InnerBean innerBean;

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public void printAll(){
        System.out.println(innerBean.getIntro());
    }
}
