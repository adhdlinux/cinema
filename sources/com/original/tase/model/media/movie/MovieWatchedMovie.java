package com.original.tase.model.media.movie;

import com.orm.SugarRecord;

public class MovieWatchedMovie extends SugarRecord {
    private String imdbId;
    private int tmdbId;

    public MovieWatchedMovie(int i2, String str) {
        this.tmdbId = i2;
        this.imdbId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovieWatchedMovie movieWatchedMovie = (MovieWatchedMovie) obj;
        if (this.tmdbId != movieWatchedMovie.tmdbId) {
            return false;
        }
        String str = this.imdbId;
        if (str != null) {
            return str.equals(movieWatchedMovie.imdbId);
        }
        if (movieWatchedMovie.imdbId != null) {
            return false;
        }
        return true;
    }

    public String getImdbId() {
        return this.imdbId;
    }

    public int getTmdbId() {
        return this.tmdbId;
    }

    public int hashCode() {
        String str = this.imdbId;
        return (str != null ? str.hashCode() : 0) + (this.tmdbId * 31);
    }

    public void setImdbId(String str) {
        this.imdbId = str;
    }

    public void setTmdbId(int i2) {
        this.tmdbId = i2;
    }
}
