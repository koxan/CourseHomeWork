package com.dnepr.step.homework.one.person;

import com.dnepr.step.homework.one.person.credit.Credit;

public interface Customer extends Person {
    int getID();
    Credit getCredit(String password);
    void setPassword(String passwd);
    String getPassword();
}
