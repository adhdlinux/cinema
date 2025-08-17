package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Movie;
import kotlin.jvm.internal.Intrinsics;

public final class AnticipatedMovie {
    @SerializedName("list_count")
    private final int listCount;
    @SerializedName("movie")
    private final Movie movie;

    public AnticipatedMovie(int i2, Movie movie2) {
        Intrinsics.f(movie2, "movie");
        this.listCount = i2;
        this.movie = movie2;
    }

    public static /* synthetic */ AnticipatedMovie copy$default(AnticipatedMovie anticipatedMovie, int i2, Movie movie2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = anticipatedMovie.listCount;
        }
        if ((i3 & 2) != 0) {
            movie2 = anticipatedMovie.movie;
        }
        return anticipatedMovie.copy(i2, movie2);
    }

    public final int component1() {
        return this.listCount;
    }

    public final Movie component2() {
        return this.movie;
    }

    public final AnticipatedMovie copy(int i2, Movie movie2) {
        Intrinsics.f(movie2, "movie");
        return new AnticipatedMovie(i2, movie2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnticipatedMovie)) {
            return false;
        }
        AnticipatedMovie anticipatedMovie = (AnticipatedMovie) obj;
        return this.listCount == anticipatedMovie.listCount && Intrinsics.a(this.movie, anticipatedMovie.movie);
    }

    public final int getListCount() {
        return this.listCount;
    }

    public final Movie getMovie() {
        return this.movie;
    }

    public int hashCode() {
        return (this.listCount * 31) + this.movie.hashCode();
    }

    public String toString() {
        return "AnticipatedMovie(listCount=" + this.listCount + ", movie=" + this.movie + ')';
    }
}
