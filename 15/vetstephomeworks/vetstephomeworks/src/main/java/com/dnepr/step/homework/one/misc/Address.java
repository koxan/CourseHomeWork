package com.dnepr.step.homework.one.misc;

public interface Address {
    String getStreetName();
    int getStreetNumber();
    String getCity();
    String getState();
    String getZipCode();
    String toString();
    boolean equals(Address addr);
}
