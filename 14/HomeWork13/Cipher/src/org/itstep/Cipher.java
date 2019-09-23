package org.itstep;


public abstract class Cipher {
    abstract String encode(String messageToEncode);
    abstract String decode(String messageToDecode);
}
