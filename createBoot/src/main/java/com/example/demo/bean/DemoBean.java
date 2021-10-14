package com.example.demo.bean;

import com.example.demo.annotation.DemoAnnotation;

import java.lang.reflect.Field;

public class DemoBean {
    public String pubField;
    protected String protectedField;
    String defaultField;
    @DemoAnnotation(description = "test" , value = "222")
    private String priField;

    public DemoBean() {
        this("pub","protect","default","pri");
    }

    public DemoBean(String pubField, String protectedField,
                    String defaultField, String priField){
        this.pubField = pubField;
        this.protectedField = protectedField;
        this.defaultField = defaultField;
        this.priField = priField;
    }

    public void function1(){
        System.out.println("public function");
    }
    protected void function2(){
        System.out.println("protect function");
    }
    void function3(){
        System.out.println("default function");
    }
    private void function4(){
        System.out.println("private function");
    }

    public static void main(String[] args){
        Class clazz = DemoBean.class;
        for (Field field: clazz.getDeclaredFields()) {
            //判断字段是否有注解
            if (field.isAnnotationPresent(DemoAnnotation.class)){
                DemoAnnotation demoAnnotation = field.getAnnotation(DemoAnnotation.class);
                System.out.println("字段:[" + field.getName() + "], 描述:[" + demoAnnotation.description() + "], 数值:[" + demoAnnotation.value() +"]");
            }
        }
    }
}
