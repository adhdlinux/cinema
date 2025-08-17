package com.uwetrottmann.trakt5.entities;

public class PersonIds extends BaseIds {
    public String slug;
    @Deprecated
    public String tvrage;

    public static PersonIds imdb(String str) {
        PersonIds personIds = new PersonIds();
        personIds.imdb = str;
        return personIds;
    }

    public static PersonIds slug(String str) {
        PersonIds personIds = new PersonIds();
        personIds.slug = str;
        return personIds;
    }

    public static PersonIds tmdb(int i2) {
        PersonIds personIds = new PersonIds();
        personIds.tmdb = Integer.valueOf(i2);
        return personIds;
    }

    public static PersonIds trakt(int i2) {
        PersonIds personIds = new PersonIds();
        personIds.trakt = Integer.valueOf(i2);
        return personIds;
    }
}
