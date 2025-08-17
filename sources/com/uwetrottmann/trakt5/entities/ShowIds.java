package com.uwetrottmann.trakt5.entities;

public class ShowIds extends BaseIds {
    public String slug;
    public Integer tvdb;
    @Deprecated
    public Integer tvrage;

    public static ShowIds imdb(String str) {
        ShowIds showIds = new ShowIds();
        showIds.imdb = str;
        return showIds;
    }

    public static ShowIds slug(String str) {
        ShowIds showIds = new ShowIds();
        showIds.slug = str;
        return showIds;
    }

    public static ShowIds tmdb(int i2) {
        ShowIds showIds = new ShowIds();
        showIds.tmdb = Integer.valueOf(i2);
        return showIds;
    }

    public static ShowIds trakt(int i2) {
        ShowIds showIds = new ShowIds();
        showIds.trakt = Integer.valueOf(i2);
        return showIds;
    }

    public static ShowIds tvdb(int i2) {
        ShowIds showIds = new ShowIds();
        showIds.tvdb = Integer.valueOf(i2);
        return showIds;
    }

    @Deprecated
    public static ShowIds tvrage(int i2) {
        ShowIds showIds = new ShowIds();
        showIds.tvrage = Integer.valueOf(i2);
        return showIds;
    }
}
