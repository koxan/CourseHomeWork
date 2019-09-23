package Example2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightMapTest {
    @Test
    public void checkIn() throws Exception {
        Set<Integer> flights = new HashSet<>();
        flights.add(1243);
        flights.add(4500);
        flights.add(9090);
        FlightMap flightMap = new FlightMap(flights);


        assertTrue(flightMap.checkIn(new Passenger("Max", "EE345566"), 1243));

        assertTrue(flightMap.checkIn(new Passenger("Vitala", "EE345523"), 9090));
        assertTrue(flightMap.checkIn(new Passenger("Ivanka", "EE345524"), 9090));
        assertTrue(flightMap.checkIn(new Passenger("Leha", "RR122233"), 9090));

        flightMap.printAll();

        assertEquals(3, flightMap.getPassengers(9090).size());
        assertEquals(1, flightMap.getPassengers(1243).size());
    }

    @Test
    public void invalidFlight() {
        Set<Integer> flights = new HashSet<>();
        flights.add(1243);
        flights.add(4500);
        flights.add(null);
        try {
            new FlightMap(flights);

        } catch (Exception e) {
            assertEquals("Flight cant be null", e.getMessage());
        }
    }

    @Test(expected = RuntimeException.class)
    public void invalidPassenger1() {
        Set<Integer> flights = new HashSet<>();
        flights.add(1243);
        FlightMap flightMap = new FlightMap(flights);
        flightMap.checkIn(new Passenger("Vitala", ""), 1243);
    }

    @Test(expected = RuntimeException.class)
    public void invalidPassenger2() {
        Set<Integer> flights = new HashSet<>();
        flights.add(1243);
        FlightMap flightMap = new FlightMap(flights);
        flightMap.checkIn(new Passenger("Vitala", ""), 2222);
    }

    @Test(expected = RuntimeException.class)
    public void invalidPassenger3() {
        Set<Integer> flights = new HashSet<>();
        flights.add(1243);
        FlightMap flightMap = new FlightMap(flights);
        flightMap.checkIn(null, 1243);
    }


}