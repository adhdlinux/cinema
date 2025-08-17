package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Show;
import kotlin.jvm.internal.Intrinsics;

public final class RecommendedShow {
    @SerializedName("show")
    private final Show show;
    @SerializedName("user_count")
    private final int userCount;

    public RecommendedShow(Show show2, int i2) {
        Intrinsics.f(show2, "show");
        this.show = show2;
        this.userCount = i2;
    }

    public static /* synthetic */ RecommendedShow copy$default(RecommendedShow recommendedShow, Show show2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            show2 = recommendedShow.show;
        }
        if ((i3 & 2) != 0) {
            i2 = recommendedShow.userCount;
        }
        return recommendedShow.copy(show2, i2);
    }

    public final Show component1() {
        return this.show;
    }

    public final int component2() {
        return this.userCount;
    }

    public final RecommendedShow copy(Show show2, int i2) {
        Intrinsics.f(show2, "show");
        return new RecommendedShow(show2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendedShow)) {
            return false;
        }
        RecommendedShow recommendedShow = (RecommendedShow) obj;
        return Intrinsics.a(this.show, recommendedShow.show) && this.userCount == recommendedShow.userCount;
    }

    public final Show getShow() {
        return this.show;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        return (this.show.hashCode() * 31) + this.userCount;
    }

    public String toString() {
        return "RecommendedShow(show=" + this.show + ", userCount=" + this.userCount + ')';
    }
}
