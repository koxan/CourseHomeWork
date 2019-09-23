package com.dnepr.step.homework.one.book;

import com.dnepr.step.homework.one.person.Author;

import java.util.Date;

public interface Book {
    String getTitle();
    Author getAuthor();
    Date getDate();
    int getEdition();
    String getDescription();
    float getPrice();
}
