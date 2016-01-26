package com.example.think.myapplication;

/**
 * Created by think on 2016/1/12.
 */
public class MyItem {
    private String name;
    private String age;

    public MyItem(String name,String age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
