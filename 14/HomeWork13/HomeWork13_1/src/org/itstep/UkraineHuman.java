package org.itstep;

/**
 * Created by Вит on 22.02.2017.
 */
public class UkraineHuman extends Human {
    String name="Я Украінець";
    @Override
    void sayHello(){

        System.out.println(name +" Доброго дня панове");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
