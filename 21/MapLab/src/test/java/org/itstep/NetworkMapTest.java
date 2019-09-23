package org.itstep;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Вит on 03.04.2017.
 */
public class NetworkMapTest {


    @Test
    public void put()throws Exception{
        NetworkMap map = new NetworkMap();
        assertTrue(map.put("ictv","Predator"));
        assertFalse(map.put("ictv","Predator"));

        assertTrue(map.put("ictv","Predator2"));
        assertTrue(map.put("ictv","Terminator1"));
        assertTrue(map.put("ictv","Terminator2"));
        assertTrue(map.put("ictv","Terminator3"));


        assertTrue(map.put("1+1","Die Hard 1"));
        assertTrue(map.put("1+1","Die Hard 2"));
        assertTrue(map.put("1+1","95 kvartal"));

        Set<String> ictv = map.getTVShows("ictv");
        assertEquals(5,ictv.size());

        Set<String> onePlusOne = map.getTVShows("1+1");
        assertEquals(3,onePlusOne.size());
    }
}