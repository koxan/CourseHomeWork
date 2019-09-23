package org.itstep;

/**
 * Created by Вит on 22.02.2017.
 */
public class RussianHuman extends Human {
  String name="Я Русский.";
    @Override
    void sayHello() {
         System.out.println(name+"  Добрый день");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
