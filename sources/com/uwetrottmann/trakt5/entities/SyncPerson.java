package com.uwetrottmann.trakt5.entities;

public class SyncPerson {
    public PersonIds ids;
    public String name;

    public SyncPerson id(PersonIds personIds) {
        this.ids = personIds;
        return this;
    }

    public SyncPerson name(String str) {
        this.name = str;
        return this;
    }
}
