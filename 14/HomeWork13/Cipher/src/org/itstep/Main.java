package org.itstep;

/**
 * Created by Вит on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) {

        CipherA cipherA = new CipherA();

        System.out.println(cipherA.encode("Арабская ночь"));

        //Вводим первую и последнюю букву верхнего и нижнего регистра и таким образом выбираем язык для кода

        Cipher russianCipher = new RussianAlphabetCipher('А','Я','а','я');
        //Вводим сообщение
        String capital = russianCipher.encode("ЧЕрвЯК");
        String small = russianCipher.encode("абвгд");



        System.out.println(capital);
        System.out.println(small);

        String decodedCapital = russianCipher.decode(capital);
        String decodedSmall = russianCipher.decode(small);

        System.out.println(decodedCapital);
        System.out.println(decodedSmall);

        Cipher ch = new RussianAlphabetCipher('A','Z','a','z');

        String bolt = ch.encode("ABC");
        String volt = ch.decode("abc");



        System.out.println(bolt);
        System.out.println(volt);

        String xbolt = ch.decode(bolt);
        String zvolt = ch.decode(volt);

        System.out.println(xbolt);
        System.out.println(zvolt);




    }
}
