package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class Show {
    @SerializedName("ids")
    private final Ids ids;
    @SerializedName("title")
    private final String title;
    @SerializedName("year")
    private final int year;

    public Show(Ids ids2, String str, int i2) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "title");
        this.ids = ids2;
        this.title = str;
        this.year = i2;
    }

    public static /* synthetic */ Show copy$default(Show show, Ids ids2, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            ids2 = show.ids;
        }
        if ((i3 & 2) != 0) {
            str = show.title;
        }
        if ((i3 & 4) != 0) {
            i2 = show.year;
        }
        return show.copy(ids2, str, i2);
    }

    public final Ids component1() {
        return this.ids;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.year;
    }

    public final Show copy(Ids ids2, String str, int i2) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "title");
        return new Show(ids2, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Show)) {
            return false;
        }
        Show show = (Show) obj;
        return Intrinsics.a(this.ids, show.ids) && Intrinsics.a(this.title, show.title) && this.year == show.year;
    }

    public final Ids getIds() {
        return this.ids;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((this.ids.hashCode() * 31) + this.title.hashCode()) * 31) + this.year;
    }

    public String toString() {
        return "Show(ids=" + this.ids + ", title=" + this.title + ", year=" + this.year + ')';
    }
}
