package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Show;
import kotlin.jvm.internal.Intrinsics;

public final class MostWatchedAndCollectedShow {
    @SerializedName("collected_count")
    private final int collectedCount;
    @SerializedName("play_count")
    private final int playCount;
    @SerializedName("show")
    private final Show show;
    @SerializedName("watcher_count")
    private final int watcherCount;

    public MostWatchedAndCollectedShow(int i2, Show show2, int i3, int i4) {
        Intrinsics.f(show2, "show");
        this.collectedCount = i2;
        this.show = show2;
        this.playCount = i3;
        this.watcherCount = i4;
    }

    public static /* synthetic */ MostWatchedAndCollectedShow copy$default(MostWatchedAndCollectedShow mostWatchedAndCollectedShow, int i2, Show show2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = mostWatchedAndCollectedShow.collectedCount;
        }
        if ((i5 & 2) != 0) {
            show2 = mostWatchedAndCollectedShow.show;
        }
        if ((i5 & 4) != 0) {
            i3 = mostWatchedAndCollectedShow.playCount;
        }
        if ((i5 & 8) != 0) {
            i4 = mostWatchedAndCollectedShow.watcherCount;
        }
        return mostWatchedAndCollectedShow.copy(i2, show2, i3, i4);
    }

    public final int component1() {
        return this.collectedCount;
    }

    public final Show component2() {
        return this.show;
    }

    public final int component3() {
        return this.playCount;
    }

    public final int component4() {
        return this.watcherCount;
    }

    public final MostWatchedAndCollectedShow copy(int i2, Show show2, int i3, int i4) {
        Intrinsics.f(show2, "show");
        return new MostWatchedAndCollectedShow(i2, show2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MostWatchedAndCollectedShow)) {
            return false;
        }
        MostWatchedAndCollectedShow mostWatchedAndCollectedShow = (MostWatchedAndCollectedShow) obj;
        return this.collectedCount == mostWatchedAndCollectedShow.collectedCount && Intrinsics.a(this.show, mostWatchedAndCollectedShow.show) && this.playCount == mostWatchedAndCollectedShow.playCount && this.watcherCount == mostWatchedAndCollectedShow.watcherCount;
    }

    public final int getCollectedCount() {
        return this.collectedCount;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final Show getShow() {
        return this.show;
    }

    public final int getWatcherCount() {
        return this.watcherCount;
    }

    public int hashCode() {
        return (((((this.collectedCount * 31) + this.show.hashCode()) * 31) + this.playCount) * 31) + this.watcherCount;
    }

    public String toString() {
        return "MostWatchedAndCollectedShow(collectedCount=" + this.collectedCount + ", show=" + this.show + ", playCount=" + this.playCount + ", watcherCount=" + this.watcherCount + ')';
    }
}
