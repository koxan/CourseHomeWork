package com.dnepr.step.homework.one.misc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonAddressTest {

    @Test
    public void equalsFalse() throws Exception {
        Address vetalAddress = new PersonAddress("пр Правды", 90, "Днепр", "Днепропетровская", "49074");
        Address dimaAddress = new PersonAddress("ул Байкальская", 11, "Днепр", "Днепропетровская", "49095");

        boolean equals = vetalAddress.equals(dimaAddress);

        Assert.assertFalse(equals);
    }

    @Test
    public void equalsTrue() throws Exception {
        Address vetalAddress = new PersonAddress("пр Правды", 90, "Днепр", "Днепропетровская", "49074");
        Address maxAddress = new PersonAddress("пр Правды", 90, "Днепр", "Днепропетровская", "49074");

        boolean equals = vetalAddress.equals(maxAddress);

        Assert.assertTrue(equals);
    }

}