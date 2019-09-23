package com.dnepr.step.homework.one.store;

import com.dnepr.step.homework.one.book.PlainBook;
import com.dnepr.step.homework.one.misc.Address;
import com.dnepr.step.homework.one.misc.PersonAddress;
import com.dnepr.step.homework.one.person.BookAuthor;
import com.dnepr.step.homework.one.person.BookStoreCustomer;
import com.dnepr.step.homework.one.person.Customer;
import com.dnepr.step.homework.one.person.credit.CustomerBookStoreCredit;
import org.junit.Assert;
import org.junit.Test;

public class DowntownBookStoreTest {

    @Test(expected = RuntimeException.class)
    public void register1() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        bookStore.register(null);
    }

    @Test(expected = RuntimeException.class)
    public void register2() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        bookStore.register(new BookStoreCustomer("Max", null, 1, new CustomerBookStoreCredit(), "password"));
    }

    @Test(expected = RuntimeException.class)
    public void register3() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        Address vetalAddress = new PersonAddress("пр Правды", 90, "Днепр", "Днепропетровская", "49074");
        bookStore.register(new BookStoreCustomer(null, vetalAddress, 1, new CustomerBookStoreCredit(), "password"));
    }

    @Test
    public void register4() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        bookStore.register(buildBookStoreCustomerVetal());

        Customer customer = bookStore.getCustomer(1);

        Assert.assertEquals("Vetal", customer.getName());
        Assert.assertEquals(1, customer.getID());
        Assert.assertEquals(90, customer.getAddress().getStreetNumber());
    }

    @Test(expected = RuntimeException.class)
    public void remove() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        BookStoreCustomer customer = buildBookStoreCustomerVetal();
        bookStore.register(customer);
        bookStore.remove(customer);

        bookStore.getCustomer(customer.getID());
    }

    private BookStoreCustomer buildBookStoreCustomerVetal() {
        Address vetalAddress = new PersonAddress("пр Правды", 90, "Днепр", "Днепропетровская", "49074");
        return new BookStoreCustomer("Vetal", vetalAddress, 1, new CustomerBookStoreCredit(), "password");
    }

    @Test
    public void getCustomer() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        BookStoreCustomer customer = buildBookStoreCustomerVetal();
        bookStore.register(customer);

        Customer foundCustomer = bookStore.getCustomer(customer.getID());

        Assert.assertEquals(customer.getID(), foundCustomer.getID());
        Assert.assertEquals(customer.getName(), foundCustomer.getName());
    }

    @Test
    public void buy() throws Exception {
        DowntownBookStore bookStore = new DowntownBookStore();
        BookStoreCustomer customer = buildBookStoreCustomerVetal();
        PersonAddress address = new PersonAddress("Правды", 90, "Днепр", null, "49116");
        BookAuthor author = new BookAuthor("Max", address, null);
       // new PlainBook("Java EE",author, 200,2, "merry",200);
        bookStore.register(customer);

        bookStore.oBuy(customer, "Java EE", 8, "Max",customer.getPassword() );
    }

}