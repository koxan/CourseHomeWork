package org.itstep;

/**
 * Created by Вит on 22.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Human human = new RussianHuman();
//        human.setName("Валера");
        human.sayHello();

        UkraineHuman human1 = new UkraineHuman();
//        human1.setName("Микола");
        human1.sayHello();


        AmericanHuman human2 = new AmericanHuman();
//        human2.setName("Mike");
        human2.sayHello();


    }

}
