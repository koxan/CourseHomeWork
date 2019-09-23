package com.dnepr.step.homework.one.person;

import com.dnepr.step.homework.one.book.Book;
import com.dnepr.step.homework.one.misc.Address;

public class BookAuthor implements Author {
    private String name;
    private Address address;
    private Book[] writtenBooks;

    public BookAuthor(String name, Address address, Book[] writtenBooks) {
        this.name = name;
        this.address = address;
        this.writtenBooks = writtenBooks;
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
    public Book[] getAllWrittenBook() {
        return writtenBooks;
    }
}
