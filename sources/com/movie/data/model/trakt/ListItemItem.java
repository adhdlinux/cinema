package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.entities.Episode;
import com.uwetrottmann.trakt5.entities.Movie;
import com.uwetrottmann.trakt5.entities.Show;
import kotlin.jvm.internal.Intrinsics;

public final class ListItemItem {
    @SerializedName("episode")
    private final Episode episode;
    @SerializedName("listed_at")
    private final String listedAt;
    @SerializedName("movie")
    private final Movie movie;
    @SerializedName("person")
    private final Person person;
    @SerializedName("rank")
    private final int rank;
    @SerializedName("season")
    private final Season season;
    @SerializedName("show")
    private final Show show;
    @SerializedName("type")
    private final String type;

    public ListItemItem(Episode episode2, String str, Movie movie2, Person person2, int i2, Season season2, Show show2, String str2) {
        Intrinsics.f(episode2, "episode");
        Intrinsics.f(str, "listedAt");
        Intrinsics.f(movie2, "movie");
        Intrinsics.f(person2, "person");
        Intrinsics.f(season2, "season");
        Intrinsics.f(show2, "show");
        Intrinsics.f(str2, "type");
        this.episode = episode2;
        this.listedAt = str;
        this.movie = movie2;
        this.person = person2;
        this.rank = i2;
        this.season = season2;
        this.show = show2;
        this.type = str2;
    }

    public static /* synthetic */ ListItemItem copy$default(ListItemItem listItemItem, Episode episode2, String str, Movie movie2, Person person2, int i2, Season season2, Show show2, String str2, int i3, Object obj) {
        ListItemItem listItemItem2 = listItemItem;
        int i4 = i3;
        return listItemItem.copy((i4 & 1) != 0 ? listItemItem2.episode : episode2, (i4 & 2) != 0 ? listItemItem2.listedAt : str, (i4 & 4) != 0 ? listItemItem2.movie : movie2, (i4 & 8) != 0 ? listItemItem2.person : person2, (i4 & 16) != 0 ? listItemItem2.rank : i2, (i4 & 32) != 0 ? listItemItem2.season : season2, (i4 & 64) != 0 ? listItemItem2.show : show2, (i4 & 128) != 0 ? listItemItem2.type : str2);
    }

    public final Episode component1() {
        return this.episode;
    }

    public final String component2() {
        return this.listedAt;
    }

    public final Movie component3() {
        return this.movie;
    }

    public final Person component4() {
        return this.person;
    }

    public final int component5() {
        return this.rank;
    }

    public final Season component6() {
        return this.season;
    }

    public final Show component7() {
        return this.show;
    }

    public final String component8() {
        return this.type;
    }

    public final ListItemItem copy(Episode episode2, String str, Movie movie2, Person person2, int i2, Season season2, Show show2, String str2) {
        Intrinsics.f(episode2, "episode");
        Intrinsics.f(str, "listedAt");
        Intrinsics.f(movie2, "movie");
        Intrinsics.f(person2, "person");
        Season season3 = season2;
        Intrinsics.f(season3, "season");
        Show show3 = show2;
        Intrinsics.f(show3, "show");
        String str3 = str2;
        Intrinsics.f(str3, "type");
        return new ListItemItem(episode2, str, movie2, person2, i2, season3, show3, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItemItem)) {
            return false;
        }
        ListItemItem listItemItem = (ListItemItem) obj;
        return Intrinsics.a(this.episode, listItemItem.episode) && Intrinsics.a(this.listedAt, listItemItem.listedAt) && Intrinsics.a(this.movie, listItemItem.movie) && Intrinsics.a(this.person, listItemItem.person) && this.rank == listItemItem.rank && Intrinsics.a(this.season, listItemItem.season) && Intrinsics.a(this.show, listItemItem.show) && Intrinsics.a(this.type, listItemItem.type);
    }

    public final Episode getEpisode() {
        return this.episode;
    }

    public final String getListedAt() {
        return this.listedAt;
    }

    public final Movie getMovie() {
        return this.movie;
    }

    public final Person getPerson() {
        return this.person;
    }

    public final int getRank() {
        return this.rank;
    }

    public final Season getSeason() {
        return this.season;
    }

    public final Show getShow() {
        return this.show;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.episode.hashCode() * 31) + this.listedAt.hashCode()) * 31) + this.movie.hashCode()) * 31) + this.person.hashCode()) * 31) + this.rank) * 31) + this.season.hashCode()) * 31) + this.show.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ListItemItem(episode=" + this.episode + ", listedAt=" + this.listedAt + ", movie=" + this.movie + ", person=" + this.person + ", rank=" + this.rank + ", season=" + this.season + ", show=" + this.show + ", type=" + this.type + ')';
    }
}
