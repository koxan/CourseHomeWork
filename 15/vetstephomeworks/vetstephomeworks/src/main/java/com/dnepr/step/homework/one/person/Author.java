package com.dnepr.step.homework.one.person;

import com.dnepr.step.homework.one.book.Book;

public interface Author extends Person {
    Book[] getAllWrittenBook();
}
