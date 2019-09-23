package com.dnepr.step.homework.one.person;

import com.dnepr.step.homework.one.misc.Address;

public interface Person {
    String getName();
    Address getAddress();
    void setAddress(Address address);
}
