package org.itstep;

/**
 * Created by Вит on 23.02.2017.
 */
public class CipherA extends Cipher {

    @Override
    String encode(String messageToEncode){

        char[] chars = messageToEncode.toCharArray();
        System.out.println(chars);
        char[] result = new char[chars.length];

        for(int i =0;i<chars.length;i++){
            int character = chars[i];
            character= character + 1;
            result[i] = (char)character;
        }

        return String.valueOf(result);

    }

    @Override
    String decode(String messageToDecode) {

        char[] chars = messageToDecode.toCharArray();
        System.out.println(chars);
        char[] result = new char[chars.length];

        for(int i =0;i<chars.length;i++){
            int a=chars[i];
            a = a - 1;
            result[i] = (char)a;
        }
        return String.valueOf(result);
    }
}
