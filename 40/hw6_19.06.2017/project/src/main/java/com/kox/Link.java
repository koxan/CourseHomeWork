package com.kox;

import java.sql.Timestamp;

public class Link {
    private int id;
    private String name;
    private String describe_link;
    private String link;
    private Timestamp created;

    public Link(int id, String name, String describe_link, String link, Timestamp created) {
        this.id = id;
        this.name = name;
        this.describe_link = describe_link;
        this.link = link;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescribe_link() {
        return describe_link;
    }

    public String getLink() {
        return link;
    }

    public Timestamp getCreated() {
        return created;
    }
}
