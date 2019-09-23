package com.dnepr.step.homework.one.store;

import com.dnepr.step.homework.one.book.Book;
import com.dnepr.step.homework.one.person.Customer;
import com.dnepr.step.homework.one.person.credit.Credit;

import java.util.ArrayList;
import java.util.List;

public class DowntownBookStore implements BookStore {
    private List<Customer> customers;
    private List<Book> books;

    public DowntownBookStore() {
        customers = new ArrayList<>();
        books = new ArrayList<>();
    }

    @Override
    public void register(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("New customer can't be null");
        }
        if (customer.getName() == null) {
            throw new RuntimeException("New customer must have a name");
        }
        if (customer.getAddress() == null) {
            throw new RuntimeException("New customer must have an address");
        }
        customers.add(customer);
    }

    @Override
    public void remove(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("Customer can't be null");
        }
        for (int i = 0; i < customers.size(); i++) {

            Customer existedCustomer = customers.get(i);

            if (customer.getID() == existedCustomer.getID()) {
                customers.remove(i);
            }
        }
        throw new RuntimeException("Customer wasn't found by ID = " + customer.getID());
    }

    @Override
    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getID() == id) {
                return customer;
            }
        }
        throw new RuntimeException("Customer wasn't found by ID = " + id);
    }

    @Override
    public boolean buy(Customer customer, Book book, int amount, String password) {
        Book boughtBook = null;
        for (int i = 0; i < books.size(); i++) {

            Book existedBook = books.get(i);

            if (existedBook.equals(book)) {
                Credit credit = customer.getCredit(password);
                boolean canAfford = credit.canAfford(amount);
                if (canAfford) {
                    boughtBook = books.remove(i);
                    credit.addDebit(amount);
                }
            }
        }
        return boughtBook != null;
    }

    @Override
    public Book oBuy(Customer customer, String title, int edition, String authorName, String password) {
        Book boughtBook = null;
        for (int i = 0; i < books.size(); i++) {

            Book existedBook = books.get(i);

            if (existedBook.getTitle().equals(title) && existedBook.getAuthor().getName().equals(authorName) && existedBook.getEdition() == edition) {

                Credit credit = customer.getCredit(password);
                float price = existedBook.getPrice();

                boolean canAfford = credit.canAfford(price);
                if (canAfford) {
                    boughtBook = books.remove(i);
                    credit.addDebit(price);
                }
            }
        }
        return boughtBook;
    }
}
