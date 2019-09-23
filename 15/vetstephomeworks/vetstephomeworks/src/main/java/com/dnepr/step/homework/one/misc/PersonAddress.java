package com.dnepr.step.homework.one.misc;

public class PersonAddress implements Address {
    private String streetName;
    private int streetNumber;
    private String city;
    private String state;
    private String zipCode;

    public PersonAddress(String streetName, int streetNumber, String city, String state, String zipCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String getStreetName() {
        return streetName;
    }

    @Override
    public int getStreetNumber() {
        return streetNumber;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Address addr) {
        if (addr == this) return false;

        if (!addr.getCity().equals(this.city)) return false;
        if (!addr.getState().equals(this.state)) return false;
        if (!addr.getStreetName().equals(this.streetName)) return false;
        if (!addr.getZipCode().equals(this.zipCode)) return false;
        if (addr.getStreetNumber() != this.streetNumber) return false;

        return true;
    }

}
