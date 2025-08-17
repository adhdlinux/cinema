package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Ids {
    @SerializedName("imdb")
    private final String imdb;
    @SerializedName("slug")
    private String slug;
    @SerializedName("tmdb")
    private final int tmdb;
    @SerializedName("trakt")
    private final int trakt;
    @SerializedName("tvdb")
    private final int tvdb;

    public Ids(String str, int i2, int i3, int i4, String str2) {
        this.imdb = str;
        this.tmdb = i2;
        this.trakt = i3;
        this.tvdb = i4;
        this.slug = str2;
    }

    private final String component5() {
        return this.slug;
    }

    public static /* synthetic */ Ids copy$default(Ids ids, String str, int i2, int i3, int i4, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ids.imdb;
        }
        if ((i5 & 2) != 0) {
            i2 = ids.tmdb;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = ids.trakt;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = ids.tvdb;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            str2 = ids.slug;
        }
        return ids.copy(str, i6, i7, i8, str2);
    }

    public final String component1() {
        return this.imdb;
    }

    public final int component2() {
        return this.tmdb;
    }

    public final int component3() {
        return this.trakt;
    }

    public final int component4() {
        return this.tvdb;
    }

    public final Ids copy(String str, int i2, int i3, int i4, String str2) {
        return new Ids(str, i2, i3, i4, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ids)) {
            return false;
        }
        Ids ids = (Ids) obj;
        return Intrinsics.a(this.imdb, ids.imdb) && this.tmdb == ids.tmdb && this.trakt == ids.trakt && this.tvdb == ids.tvdb && Intrinsics.a(this.slug, ids.slug);
    }

    public final String getImdb() {
        return this.imdb;
    }

    public final int getTmdb() {
        return this.tmdb;
    }

    public final int getTrakt() {
        return this.trakt;
    }

    public final int getTvdb() {
        return this.tvdb;
    }

    public int hashCode() {
        String str = this.imdb;
        int i2 = 0;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.tmdb) * 31) + this.trakt) * 31) + this.tvdb) * 31;
        String str2 = this.slug;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "Ids(imdb=" + this.imdb + ", tmdb=" + this.tmdb + ", trakt=" + this.trakt + ", tvdb=" + this.tvdb + ", slug=" + this.slug + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ids(String str, int i2, int i3, int i4, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i2, i3, i4, (i5 & 16) != 0 ? null : str2);
    }
}
