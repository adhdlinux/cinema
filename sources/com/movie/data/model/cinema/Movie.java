package com.movie.data.model.cinema;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.database.entitys.MovieEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.movie.data.model.MovieConverter;
import com.utils.Lists;
import java.util.ArrayList;
import java.util.List;

public final class Movie implements Parcelable, MovieConverter {
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        public Movie[] newArray(int i2) {
            return new Movie[i2];
        }
    };
    @SerializedName("backdrop_path")
    @Expose
    String backdropPath;
    boolean favored;
    @SerializedName("genre_ids")
    @Expose
    List<Integer> genreIds;
    List<Genre> genres;
    @SerializedName("ggLinks")
    @Expose
    List<String> ggLinks;
    @Expose
    long id;
    @Expose
    String imdb_id;
    @Expose
    String overview;
    @Expose
    double popularity;
    @SerializedName("poster_path")
    @Expose
    String posterPath;
    @Expose
    String quality;
    @SerializedName("release_date")
    @Expose
    String releaseDate;
    @Expose
    String subtitle_identify;
    @Expose
    String title;
    @Expose
    int tmvdbID;
    @Expose
    TV tv;
    @SerializedName("vote_average")
    @Expose
    double voteAverage;
    @SerializedName("vote_count")
    @Expose
    long voteCount;

    public static final class Response {
        @SerializedName("results")
        @Expose
        public List<Movie> movies = new ArrayList();
        @Expose
        public int page;
        @SerializedName("total_results")
        @Expose
        public int totalMovies;
        @SerializedName("total_pages")
        @Expose
        public int totalPages;
    }

    protected Movie(Parcel parcel) {
        this.genreIds = new ArrayList();
        this.ggLinks = new ArrayList();
        boolean z2 = false;
        this.favored = false;
        this.id = parcel.readLong();
        this.ggLinks = parcel.createStringArrayList();
        this.overview = parcel.readString();
        this.releaseDate = parcel.readString();
        this.posterPath = parcel.readString();
        this.backdropPath = parcel.readString();
        this.popularity = parcel.readDouble();
        this.title = parcel.readString();
        this.quality = parcel.readString();
        this.voteAverage = parcel.readDouble();
        this.voteCount = parcel.readLong();
        this.tmvdbID = parcel.readInt();
        this.imdb_id = parcel.readString();
        this.tv = (TV) parcel.readParcelable(TV.class.getClassLoader());
        this.subtitle_identify = parcel.readString();
        this.favored = parcel.readByte() != 0 ? true : z2;
        this.genres = parcel.createTypedArrayList(Genre.CREATOR);
    }

    public MovieEntity convert() {
        boolean z2;
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTmdbID((long) getTmvdbID());
        movieEntity.setImdbIDStr(getImdb_id());
        movieEntity.setPoster_path(getPosterPath());
        movieEntity.setBackdrop_path(getBackdropPath());
        movieEntity.setName(getTitle());
        movieEntity.setRealeaseDate(getReleaseDate());
        movieEntity.setOverview(getOverview());
        movieEntity.setVote(Double.valueOf(getVoteAverage()));
        if (getTv() == null || getTv().id <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        movieEntity.setTV(Boolean.valueOf(z2));
        movieEntity.setNumberSeason(getTv().sessions.size());
        return movieEntity;
    }

    public int describeContents() {
        return 0;
    }

    public String getBackdropPath() {
        return this.backdropPath;
    }

    public List<Integer> getGenreIds() {
        return this.genreIds;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public List<String> getGgLinks() {
        return this.ggLinks;
    }

    public long getId() {
        return this.id;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public String getOverview() {
        return this.overview;
    }

    public double getPopularity() {
        return this.popularity;
    }

    public String getPosterPath() {
        return this.posterPath;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getSubtitle_identify() {
        return this.subtitle_identify;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTmvdbID() {
        if (getTv() == null || getTv().id <= 0) {
            return this.tmvdbID;
        }
        return getTv().id;
    }

    public TV getTv() {
        return this.tv;
    }

    public double getVoteAverage() {
        return this.voteAverage;
    }

    public long getVoteCount() {
        return this.voteCount;
    }

    public boolean isFavored() {
        return this.favored;
    }

    public String makeGenreIdsList() {
        if (Lists.a(this.genreIds)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.genreIds.get(0));
        for (int i2 = 1; i2 < this.genreIds.size(); i2++) {
            sb.append(",");
            sb.append(this.genreIds.get(i2));
        }
        return sb.toString();
    }

    public Movie putGenreIdsList(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.genreIds = new ArrayList();
            for (String parseInt : str.split(",")) {
                this.genreIds.add(Integer.valueOf(Integer.parseInt(parseInt)));
            }
        }
        return this;
    }

    public Movie setBackdropPath(String str) {
        this.backdropPath = str;
        return this;
    }

    public Movie setFavored(boolean z2) {
        this.favored = z2;
        return this;
    }

    public Movie setGenreIds(List<Integer> list) {
        this.genreIds = list;
        return this;
    }

    public Movie setGenres(List<Genre> list) {
        this.genres = list;
        return this;
    }

    public Movie setId(long j2) {
        this.id = j2;
        return this;
    }

    public Movie setOverview(String str) {
        this.overview = str;
        return this;
    }

    public Movie setPopularity(double d2) {
        this.popularity = d2;
        return this;
    }

    public Movie setPosterPath(String str) {
        this.posterPath = str;
        return this;
    }

    public Movie setReleaseDate(String str) {
        this.releaseDate = str;
        return this;
    }

    public void setSubtitle_identify(String str) {
        this.subtitle_identify = str;
    }

    public Movie setTV(TV tv2) {
        this.tv = tv2;
        return this;
    }

    public Movie setTitle(String str) {
        this.title = str;
        return this;
    }

    public void setTv(TV tv2) {
        this.tv = tv2;
    }

    public Movie setVoteAverage(double d2) {
        this.voteAverage = d2;
        return this;
    }

    public Movie setVoteCount(long j2) {
        this.voteCount = j2;
        return this;
    }

    public String toString() {
        return "Movie{ title='" + this.title + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.id);
        parcel.writeStringList(this.ggLinks);
        parcel.writeString(this.overview);
        parcel.writeString(this.releaseDate);
        parcel.writeString(this.posterPath);
        parcel.writeString(this.backdropPath);
        parcel.writeDouble(this.popularity);
        parcel.writeString(this.title);
        parcel.writeString(this.quality);
        parcel.writeDouble(this.voteAverage);
        parcel.writeLong(this.voteCount);
        parcel.writeInt(this.tmvdbID);
        parcel.writeString(this.imdb_id);
        parcel.writeParcelable(this.tv, i2);
        parcel.writeString(this.subtitle_identify);
        parcel.writeByte(this.favored ? (byte) 1 : 0);
        parcel.writeTypedList(this.genres);
    }

    public static final class TV implements Parcelable {
        public static final Parcelable.Creator<TV> CREATOR = new Parcelable.Creator<TV>() {
            public TV createFromParcel(Parcel parcel) {
                return new TV(parcel);
            }

            public TV[] newArray(int i2) {
                return new TV[i2];
            }
        };
        @Expose
        public int id;
        @Expose
        public List<Integer> sessions;

        public TV(int i2, int i3) {
            this.id = i2;
            this.sessions = new ArrayList();
            int i4 = 0;
            while (i4 < i3) {
                i4++;
                this.sessions.add(Integer.valueOf(i4));
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.id);
            parcel.writeList(this.sessions);
        }

        protected TV(Parcel parcel) {
            this.id = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            this.sessions = arrayList;
            parcel.readList(arrayList, List.class.getClassLoader());
        }
    }

    public Movie() {
        this.genreIds = new ArrayList();
        this.ggLinks = new ArrayList();
        this.favored = false;
    }
}
