package org.itstep;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class NumberAnalyzerTest {

    @Test
    public void evenNumbers() throws Exception {
        NumberAnalyzer na = new NumberAnalyzer();
        EvenNumberInfo info = na.evenNumbers("numbers1.txt");

        assertEquals(9, info.getTotalNumbers());
        assertEquals(BigInteger.valueOf(752), info.getSummation());
        assertEquals(3, info.getTotalEvenNumbersCount());
        assertEquals(33.33, info.getEvenNumberPercentage(), 0.004);
    }

}