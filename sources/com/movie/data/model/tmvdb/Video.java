package com.movie.data.model.tmvdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class Video implements Parcelable {
    public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() {
        public Video createFromParcel(Parcel parcel) {
            return new Video(parcel);
        }

        public Video[] newArray(int i2) {
            return new Video[i2];
        }
    };
    public static final String SITE_YOUTUBE = "YouTube";
    public static final String TYPE_STREAM = "Stream";
    public static final String TYPE_TRAILER = "Trailer";
    @Expose
    private String id;
    @SerializedName("iso_639_1")
    @Expose
    private String iso;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String site;
    @Expose
    private int size;
    @Expose
    private String type;

    public static final class Response {
        @Expose
        public long id;
        @Expose
        public String linkID;
        @Expose
        public String movieID;
        @SerializedName("results")
        @Expose
        public List<Video> videos;
    }

    public Video() {
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public String getIso() {
        return this.iso;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getSite() {
        return this.site;
    }

    public int getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    public Video setId(String str) {
        this.id = str;
        return this;
    }

    public Video setIso(String str) {
        this.iso = str;
        return this;
    }

    public Video setKey(String str) {
        this.key = str;
        return this;
    }

    public Video setName(String str) {
        this.name = str;
        return this;
    }

    public Video setSite(String str) {
        this.site = str;
        return this;
    }

    public Video setSize(int i2) {
        this.size = i2;
        return this;
    }

    public Video setType(String str) {
        this.type = str;
        return this;
    }

    public String toString() {
        return "Video{key='" + this.key + '\'' + ", name='" + this.name + '\'' + ", site='" + this.site + '\'' + ", type='" + this.type + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.iso);
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeString(this.site);
        parcel.writeInt(this.size);
        parcel.writeString(this.type);
    }

    protected Video(Parcel parcel) {
        this.id = parcel.readString();
        this.iso = parcel.readString();
        this.key = parcel.readString();
        this.name = parcel.readString();
        this.site = parcel.readString();
        this.size = parcel.readInt();
        this.type = parcel.readString();
    }
}
