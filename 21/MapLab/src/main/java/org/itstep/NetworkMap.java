package org.itstep;

import java.util.*;

/**
 * Created by Вит on 03.04.2017.
 */
public class NetworkMap {

    Map<String,Set<String>> networkMap;

    public NetworkMap() {
        networkMap = new HashMap<>();
    }

    public boolean put(String channelName,String showName){
        if(networkMap.containsKey(channelName)){
            if(networkMap.get(channelName).contains(showName)){
                return false;
            }else{
                networkMap.get(channelName).add(showName);
                return  true;
            }
        }else{
            Set<String> shows = new TreeSet<>();
            shows.add(showName);
            networkMap.put(channelName,shows);
            return true;
        }
    }

    public Set<String> getTVShows(String channelName){
        return networkMap.getOrDefault(channelName, Collections.emptySet());
    }

    public void printChannels(){
        Set<String> sortedChannels = new TreeSet<>(networkMap.keySet());
        for(String channel : sortedChannels){
            System.out.printf("TV shows on channel %s: %s\n",channel,networkMap.get(channel));
        }
    }

    @Override
    public String toString() {
        return "NetworkMap{" +
                "networkMap=" + networkMap +
                '}';
    }
}
