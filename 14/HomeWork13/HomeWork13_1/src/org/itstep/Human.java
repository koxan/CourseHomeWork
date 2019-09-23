package org.itstep;


public abstract class Human {
    public String name;

    void sayHello(){
        System.out.println("Добрый день");
    }

    public void setName(String name) {
        this.name = name;
    }
}
