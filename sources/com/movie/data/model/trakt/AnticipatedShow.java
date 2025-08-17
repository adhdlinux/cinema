package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Show;
import kotlin.jvm.internal.Intrinsics;

public final class AnticipatedShow {
    @SerializedName("list_count")
    private final int listCount;
    @SerializedName("show")
    private final Show show;

    public AnticipatedShow(int i2, Show show2) {
        Intrinsics.f(show2, "show");
        this.listCount = i2;
        this.show = show2;
    }

    public static /* synthetic */ AnticipatedShow copy$default(AnticipatedShow anticipatedShow, int i2, Show show2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = anticipatedShow.listCount;
        }
        if ((i3 & 2) != 0) {
            show2 = anticipatedShow.show;
        }
        return anticipatedShow.copy(i2, show2);
    }

    public final int component1() {
        return this.listCount;
    }

    public final Show component2() {
        return this.show;
    }

    public final AnticipatedShow copy(int i2, Show show2) {
        Intrinsics.f(show2, "show");
        return new AnticipatedShow(i2, show2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnticipatedShow)) {
            return false;
        }
        AnticipatedShow anticipatedShow = (AnticipatedShow) obj;
        return this.listCount == anticipatedShow.listCount && Intrinsics.a(this.show, anticipatedShow.show);
    }

    public final int getListCount() {
        return this.listCount;
    }

    public final Show getShow() {
        return this.show;
    }

    public int hashCode() {
        return (this.listCount * 31) + this.show.hashCode();
    }

    public String toString() {
        return "AnticipatedShow(listCount=" + this.listCount + ", show=" + this.show + ')';
    }
}
