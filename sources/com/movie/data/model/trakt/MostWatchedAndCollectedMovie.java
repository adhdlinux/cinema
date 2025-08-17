package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Movie;
import kotlin.jvm.internal.Intrinsics;

public final class MostWatchedAndCollectedMovie {
    @SerializedName("collected_count")
    private final int collectedCount;
    @SerializedName("movie")
    private final Movie movie;
    @SerializedName("play_count")
    private final int playCount;
    @SerializedName("watcher_count")
    private final int watcherCount;

    public MostWatchedAndCollectedMovie(int i2, Movie movie2, int i3, int i4) {
        Intrinsics.f(movie2, "movie");
        this.collectedCount = i2;
        this.movie = movie2;
        this.playCount = i3;
        this.watcherCount = i4;
    }

    public static /* synthetic */ MostWatchedAndCollectedMovie copy$default(MostWatchedAndCollectedMovie mostWatchedAndCollectedMovie, int i2, Movie movie2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = mostWatchedAndCollectedMovie.collectedCount;
        }
        if ((i5 & 2) != 0) {
            movie2 = mostWatchedAndCollectedMovie.movie;
        }
        if ((i5 & 4) != 0) {
            i3 = mostWatchedAndCollectedMovie.playCount;
        }
        if ((i5 & 8) != 0) {
            i4 = mostWatchedAndCollectedMovie.watcherCount;
        }
        return mostWatchedAndCollectedMovie.copy(i2, movie2, i3, i4);
    }

    public final int component1() {
        return this.collectedCount;
    }

    public final Movie component2() {
        return this.movie;
    }

    public final int component3() {
        return this.playCount;
    }

    public final int component4() {
        return this.watcherCount;
    }

    public final MostWatchedAndCollectedMovie copy(int i2, Movie movie2, int i3, int i4) {
        Intrinsics.f(movie2, "movie");
        return new MostWatchedAndCollectedMovie(i2, movie2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MostWatchedAndCollectedMovie)) {
            return false;
        }
        MostWatchedAndCollectedMovie mostWatchedAndCollectedMovie = (MostWatchedAndCollectedMovie) obj;
        return this.collectedCount == mostWatchedAndCollectedMovie.collectedCount && Intrinsics.a(this.movie, mostWatchedAndCollectedMovie.movie) && this.playCount == mostWatchedAndCollectedMovie.playCount && this.watcherCount == mostWatchedAndCollectedMovie.watcherCount;
    }

    public final int getCollectedCount() {
        return this.collectedCount;
    }

    public final Movie getMovie() {
        return this.movie;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final int getWatcherCount() {
        return this.watcherCount;
    }

    public int hashCode() {
        return (((((this.collectedCount * 31) + this.movie.hashCode()) * 31) + this.playCount) * 31) + this.watcherCount;
    }

    public String toString() {
        return "MostWatchedAndCollectedMovie(collectedCount=" + this.collectedCount + ", movie=" + this.movie + ", playCount=" + this.playCount + ", watcherCount=" + this.watcherCount + ')';
    }
}
