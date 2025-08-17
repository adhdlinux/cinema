package com.movie.data.model.cinema;

import android.os.Parcel;
import android.os.Parcelable;
import com.database.entitys.GenreEntity;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

public class Genre implements Parcelable {
    public static final Parcelable.Creator<Genre> CREATOR = new Parcelable.Creator<Genre>() {
        public Genre createFromParcel(Parcel parcel) {
            return new Genre(parcel);
        }

        public Genre[] newArray(int i2) {
            return new Genre[i2];
        }
    };
    @Expose
    private int id;
    @Expose
    private String name;
    private String sortField;

    public static class Response {
        @Expose
        public List<Genre> genres = new ArrayList();
    }

    public Genre() {
    }

    public GenreEntity convertToEntity() {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.b(getId());
        genreEntity.c(getName());
        return genreEntity;
    }

    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSortField() {
        return this.sortField;
    }

    public Genre setId(int i2) {
        this.id = i2;
        return this;
    }

    public Genre setName(String str) {
        this.name = str;
        return this;
    }

    public void setSortField(String str) {
        this.sortField = str;
    }

    public String toString() {
        return this.name;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
    }

    public Genre(int i2, String str) {
        this.id = i2;
        this.name = str;
    }

    protected Genre(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
    }
}
