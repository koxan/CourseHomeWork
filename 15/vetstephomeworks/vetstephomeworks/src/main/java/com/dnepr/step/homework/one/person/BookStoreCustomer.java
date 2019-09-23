package com.dnepr.step.homework.one.person;

import com.dnepr.step.homework.one.misc.Address;
import com.dnepr.step.homework.one.person.credit.Credit;

public class BookStoreCustomer implements Customer {
    private String name;
    private Address address;
    private int id;
    private Credit credit;
    private String password;

    public BookStoreCustomer(String name, Address address, int id, Credit credit, String password) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.credit = credit;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Credit getCredit(String password) {
        if (password == null) {
            throw new RuntimeException("Provided password can't be null");
        }
        if (!this.password.equals(password)) {
            throw new RuntimeException("Provided password is incorrect");
        }
        return credit;
    }

    @Override
    public void setPassword(String passwd) {
        password = passwd;
    }

    @Override
    public String getPassword() {
        return password;
    }


}
