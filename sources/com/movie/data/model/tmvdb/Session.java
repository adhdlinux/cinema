package com.movie.data.model.tmvdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

public final class Session implements Parcelable {
    public static final Parcelable.Creator<Session> CREATOR = new Parcelable.Creator<Session>() {
        public Session createFromParcel(Parcel parcel) {
            return new Session(parcel);
        }

        public Session[] newArray(int i2) {
            return new Session[i2];
        }
    };
    @Expose
    private String air_date;
    @Expose
    private int episode_count;
    @Expose
    private int id;
    @Expose
    private int movieID;
    @Expose
    private String poster_path;
    @Expose
    private int season_number;
    @Expose
    private List<Series> series;
    @Expose
    private int tvID;

    public static final class Response {
        @Expose
        public List<Session> sessions;
    }

    public Session() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAir_date() {
        return this.air_date;
    }

    public int getEpisode_count() {
        return this.episode_count;
    }

    public int getId() {
        return this.id;
    }

    public int getMovieID() {
        return this.movieID;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public int getSeason_number() {
        return this.season_number;
    }

    public List<Series> getSeries() {
        return this.series;
    }

    public int getTvID() {
        return this.tvID;
    }

    public String toString() {
        return "";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.movieID);
        parcel.writeInt(this.tvID);
        parcel.writeInt(this.id);
        parcel.writeInt(this.season_number);
        parcel.writeInt(this.episode_count);
        parcel.writeList(this.series);
        parcel.writeString(this.poster_path);
        parcel.writeString(this.air_date);
    }

    protected Session(Parcel parcel) {
        this.series = new ArrayList();
        this.movieID = parcel.readInt();
        this.tvID = parcel.readInt();
        this.id = parcel.readInt();
        this.season_number = parcel.readInt();
        this.episode_count = parcel.readInt();
        parcel.readList(this.series, Series.class.getClassLoader());
        this.poster_path = parcel.readString();
        this.air_date = parcel.readString();
    }
}
