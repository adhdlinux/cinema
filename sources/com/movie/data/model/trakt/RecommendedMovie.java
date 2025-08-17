package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Movie;
import kotlin.jvm.internal.Intrinsics;

public final class RecommendedMovie {
    @SerializedName("movie")
    private final Movie movie;
    @SerializedName("user_count")
    private final int userCount;

    public RecommendedMovie(Movie movie2, int i2) {
        Intrinsics.f(movie2, "movie");
        this.movie = movie2;
        this.userCount = i2;
    }

    public static /* synthetic */ RecommendedMovie copy$default(RecommendedMovie recommendedMovie, Movie movie2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            movie2 = recommendedMovie.movie;
        }
        if ((i3 & 2) != 0) {
            i2 = recommendedMovie.userCount;
        }
        return recommendedMovie.copy(movie2, i2);
    }

    public final Movie component1() {
        return this.movie;
    }

    public final int component2() {
        return this.userCount;
    }

    public final RecommendedMovie copy(Movie movie2, int i2) {
        Intrinsics.f(movie2, "movie");
        return new RecommendedMovie(movie2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendedMovie)) {
            return false;
        }
        RecommendedMovie recommendedMovie = (RecommendedMovie) obj;
        return Intrinsics.a(this.movie, recommendedMovie.movie) && this.userCount == recommendedMovie.userCount;
    }

    public final Movie getMovie() {
        return this.movie;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        return (this.movie.hashCode() * 31) + this.userCount;
    }

    public String toString() {
        return "RecommendedMovie(movie=" + this.movie + ", userCount=" + this.userCount + ')';
    }
}
