package org.itstep;


public class AmericanHuman extends Human {
    String name="I'm American";
    @Override
    void sayHello(){

        System.out.println(name +" Hello man");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
