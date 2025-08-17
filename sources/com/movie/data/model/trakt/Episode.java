package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class Episode {
    @SerializedName("ids")
    private final Ids ids;
    @SerializedName("number")
    private final int number;
    @SerializedName("season")
    private final int season;
    @SerializedName("title")
    private final String title;

    public Episode(Ids ids2, int i2, int i3, String str) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "title");
        this.ids = ids2;
        this.number = i2;
        this.season = i3;
        this.title = str;
    }

    public static /* synthetic */ Episode copy$default(Episode episode, Ids ids2, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            ids2 = episode.ids;
        }
        if ((i4 & 2) != 0) {
            i2 = episode.number;
        }
        if ((i4 & 4) != 0) {
            i3 = episode.season;
        }
        if ((i4 & 8) != 0) {
            str = episode.title;
        }
        return episode.copy(ids2, i2, i3, str);
    }

    public final Ids component1() {
        return this.ids;
    }

    public final int component2() {
        return this.number;
    }

    public final int component3() {
        return this.season;
    }

    public final String component4() {
        return this.title;
    }

    public final Episode copy(Ids ids2, int i2, int i3, String str) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "title");
        return new Episode(ids2, i2, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Episode)) {
            return false;
        }
        Episode episode = (Episode) obj;
        return Intrinsics.a(this.ids, episode.ids) && this.number == episode.number && this.season == episode.season && Intrinsics.a(this.title, episode.title);
    }

    public final Ids getIds() {
        return this.ids;
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getSeason() {
        return this.season;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.ids.hashCode() * 31) + this.number) * 31) + this.season) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "Episode(ids=" + this.ids + ", number=" + this.number + ", season=" + this.season + ", title=" + this.title + ')';
    }
}
