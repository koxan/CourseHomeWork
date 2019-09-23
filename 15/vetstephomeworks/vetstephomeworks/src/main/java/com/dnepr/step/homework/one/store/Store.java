package com.dnepr.step.homework.one.store;

import com.dnepr.step.homework.one.person.Customer;

public interface Store {
    void register(Customer customer);
    void remove(Customer customer);
    Customer getCustomer(int id);
}
