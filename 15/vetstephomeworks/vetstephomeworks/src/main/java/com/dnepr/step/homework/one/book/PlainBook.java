package com.dnepr.step.homework.one.book;

import com.dnepr.step.homework.one.person.Author;

import java.util.Date;

public class PlainBook implements Book {
    private String title;
    private Author author;
    private Date date;
    private int edition;
    private String description;
    private float price;

    public PlainBook(String title, Author author, Date date, int edition, String description, float price) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.edition = edition;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public int getEdition() {
        return edition;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainBook)) return false;

        PlainBook plainBook = (PlainBook) o;

        if (edition != plainBook.edition) return false;
        if (Float.compare(plainBook.price, price) != 0) return false;
        if (!title.equals(plainBook.title)) return false;
        if (!author.equals(plainBook.author)) return false;
        if (!date.equals(plainBook.date)) return false;
        return description.equals(plainBook.description);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + edition;
        result = 31 * result + description.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }
}
