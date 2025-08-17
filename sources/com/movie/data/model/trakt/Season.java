package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class Season {
    @SerializedName("ids")
    private final Ids ids;
    @SerializedName("number")
    private final int number;

    public Season(Ids ids2, int i2) {
        Intrinsics.f(ids2, "ids");
        this.ids = ids2;
        this.number = i2;
    }

    public static /* synthetic */ Season copy$default(Season season, Ids ids2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            ids2 = season.ids;
        }
        if ((i3 & 2) != 0) {
            i2 = season.number;
        }
        return season.copy(ids2, i2);
    }

    public final Ids component1() {
        return this.ids;
    }

    public final int component2() {
        return this.number;
    }

    public final Season copy(Ids ids2, int i2) {
        Intrinsics.f(ids2, "ids");
        return new Season(ids2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Season)) {
            return false;
        }
        Season season = (Season) obj;
        return Intrinsics.a(this.ids, season.ids) && this.number == season.number;
    }

    public final Ids getIds() {
        return this.ids;
    }

    public final int getNumber() {
        return this.number;
    }

    public int hashCode() {
        return (this.ids.hashCode() * 31) + this.number;
    }

    public String toString() {
        return "Season(ids=" + this.ids + ", number=" + this.number + ')';
    }
}
