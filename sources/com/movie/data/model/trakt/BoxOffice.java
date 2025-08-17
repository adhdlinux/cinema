package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Movie;
import kotlin.jvm.internal.Intrinsics;

public final class BoxOffice {
    @SerializedName("movie")
    private final Movie movie;
    @SerializedName("revenue")
    private final int revenue;

    public BoxOffice(Movie movie2, int i2) {
        Intrinsics.f(movie2, "movie");
        this.movie = movie2;
        this.revenue = i2;
    }

    public static /* synthetic */ BoxOffice copy$default(BoxOffice boxOffice, Movie movie2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            movie2 = boxOffice.movie;
        }
        if ((i3 & 2) != 0) {
            i2 = boxOffice.revenue;
        }
        return boxOffice.copy(movie2, i2);
    }

    public final Movie component1() {
        return this.movie;
    }

    public final int component2() {
        return this.revenue;
    }

    public final BoxOffice copy(Movie movie2, int i2) {
        Intrinsics.f(movie2, "movie");
        return new BoxOffice(movie2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxOffice)) {
            return false;
        }
        BoxOffice boxOffice = (BoxOffice) obj;
        return Intrinsics.a(this.movie, boxOffice.movie) && this.revenue == boxOffice.revenue;
    }

    public final Movie getMovie() {
        return this.movie;
    }

    public final int getRevenue() {
        return this.revenue;
    }

    public int hashCode() {
        return (this.movie.hashCode() * 31) + this.revenue;
    }

    public String toString() {
        return "BoxOffice(movie=" + this.movie + ", revenue=" + this.revenue + ')';
    }
}
