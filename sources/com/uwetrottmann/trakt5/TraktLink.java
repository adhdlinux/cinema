package com.uwetrottmann.trakt5;

public class TraktLink {
    private static final String PATH_EPISODES = "/episodes/";
    private static final String PATH_SEASONS = "/seasons/";
    private static final String URL_COMMENT = "https://trakt.tv/comments/";
    private static final String URL_EPISODE = "https://trakt.tv/episodes/";
    private static final String URL_IMDB = "https://trakt.tv/search/imdb/";
    private static final String URL_MOVIE = "https://trakt.tv/movies/";
    private static final String URL_PERSON = "https://trakt.tv/people/";
    private static final String URL_SEASON = "https://trakt.tv/seasons/";
    private static final String URL_SHOW = "https://trakt.tv/shows/";
    private static final String URL_TMDB = "https://trakt.tv/search/tmdb/";
    private static final String URL_TVDB = "https://trakt.tv/search/tvdb/";
    @Deprecated
    private static final String URL_TVRAGE = "https://trakt.tv/search/tvrage/";

    public static String comment(int i2) {
        return URL_COMMENT + i2;
    }

    public static String episode(int i2) {
        return URL_EPISODE + i2;
    }

    public static String imdb(String str) {
        return URL_IMDB + str;
    }

    public static String movie(String str) {
        return URL_MOVIE + str;
    }

    public static String person(String str) {
        return URL_PERSON + str;
    }

    public static String season(int i2) {
        return URL_SEASON + i2;
    }

    public static String show(String str) {
        return URL_SHOW + str;
    }

    public static String tmdb(int i2) {
        return URL_TMDB + i2;
    }

    public static String tvdb(int i2) {
        return URL_TVDB + i2;
    }

    @Deprecated
    public static String tvrage(int i2) {
        return URL_TVRAGE + i2;
    }

    public static String episode(int i2, int i3, int i4) {
        return show(String.valueOf(i2)) + PATH_SEASONS + i3 + PATH_EPISODES + i4;
    }

    public static String season(int i2, int i3) {
        return show(String.valueOf(i2)) + PATH_SEASONS + i3;
    }
}
