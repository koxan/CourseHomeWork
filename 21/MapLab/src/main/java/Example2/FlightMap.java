package Example2;

import java.util.*;

/**
 * Created by Вит on 03.04.2017.
 */
public class FlightMap {

    private Map<Integer,List<Passenger>> flightInformation;
    public FlightMap(Set<Integer> flights){
        flightInformation = new TreeMap<>();
        for (Integer flight: flights) {
            if(flight == null){
                throw new RuntimeException("Flight cant be null");
            }
            flightInformation.put(flight,new ArrayList<>());
        }
    }
    public boolean checkIn(Passenger passenger,int flightNumber){
        validate(passenger,flightNumber);
        List<Passenger> passengers = flightInformation.get(flightNumber);
        passengers.add(passenger);
        return  true;
    }

    public void printAll(){
        for(Integer key:flightInformation.keySet()){
            System.out.printf("Flight number %d: %s\n",key,getPassengers(key));
        }
    }
    public List<Passenger> getPassengers(int flightNumber){
        List<Passenger> passengers = flightInformation.get(flightNumber);
        Collections.sort(passengers);
        return  passengers;
    }

    private void validate(Passenger passenger,int flightNumber){
        if(passenger == null){
            throw new RuntimeException("Passenger cant be null");
        }
        if(passenger.getName()==null||passenger.getName().isEmpty()){
            throw new RuntimeException("Passengers name is not specified");
        }
        if(passenger.getDocumentNumber()==null||passenger.getDocumentNumber().isEmpty()){
            throw new RuntimeException("Passengers document is not specified");
        }
        if(!flightInformation.keySet().contains(flightNumber)){
            throw new RuntimeException(String.format("Flight %d is not found",flightNumber));
        }
    }
}
