package org.itstep;

/**
 * Created by Вит on 23.02.2017.
 */
public class RussianAlphabetCipher extends Cipher {

    private final char firstLetterSmall;
            //= 'а';
    private final char lastLetterSmall;
                    //= 'я';

    private final int firstLetterCapital;
            //= 'А';
    private final int lastLetterCapital;
            //= 'Я';

    private final char space = ' ';

    RussianAlphabetCipher(char firstLetterCapital,char lastLetterCapital,char firstLetterSmall,char lastLetterSmall){
        this.firstLetterCapital=firstLetterCapital;
        this.lastLetterCapital=lastLetterCapital;
        this.firstLetterSmall=firstLetterSmall;
        this.lastLetterSmall=lastLetterSmall;

    }

    @Override
    String decode(String messageToDecode) {
        return encode(messageToDecode);
    }

    @Override
    String encode(String messageToEncode) {

        char[] chars = messageToEncode.toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            if (isSkip(aChar)) {
                result[i] = aChar;
                continue;
            }

            if (isCapital(aChar)) {
                int shifted = aChar - firstLetterCapital;
                int newCodePoint = lastLetterCapital - shifted;
                result[i] = (char)newCodePoint;
            } else if (isSmall(aChar)) {
                int shifted = aChar - firstLetterSmall;
                int newCodePoint = lastLetterSmall - shifted;
                result[i] = (char)newCodePoint;
            } else {
                throw new RuntimeException("Incorrect symbol: " + aChar);
            }
        }
        return String.valueOf(result);
    }

    private boolean isSkip(char aChar) {
        return aChar == space;
    }


    private boolean isSmall(char aChar) {
        return aChar <= lastLetterSmall && aChar >= firstLetterSmall;
    }

    private boolean isCapital(char aChar) {
        return aChar <= lastLetterCapital && aChar >= firstLetterCapital;
    }

}
