package com.dnepr.step.homework.one.person.credit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerBookStoreCreditTest {

    @Test(expected = RuntimeException.class)
    public void addDebit1() throws Exception {
        CustomerBookStoreCredit credit = new CustomerBookStoreCredit();
        credit.addDebit(-100);
    }

    @Test
    public void addDebit2() throws Exception {
        CustomerBookStoreCredit credit = new CustomerBookStoreCredit();
        credit.addDebit(500);
        credit.addDebit(400);
        credit.addDebit(99);
        Assert.assertEquals(999, credit.getDebit());
    }

    @Test(expected = RuntimeException.class)
    public void addDebit3() throws Exception {
        CustomerBookStoreCredit credit = new CustomerBookStoreCredit();
        credit.addDebit(1001);
    }

    @Test
    public void addDebit4() throws Exception {
        CustomerBookStoreCredit credit = new CustomerBookStoreCredit();
        Assert.assertEquals(0, credit.getDebit());
    }

}