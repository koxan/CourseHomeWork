package com.dnepr.step.homework.one.store;

import com.dnepr.step.homework.one.book.Book;
import com.dnepr.step.homework.one.person.Customer;

public interface BookStore extends Store {
    boolean buy(Customer customer, Book book, int amount, String password);

    Book oBuy(Customer customer, String title, int edition, String authorName, String password);
}
