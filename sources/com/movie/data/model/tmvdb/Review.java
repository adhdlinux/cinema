package com.movie.data.model.tmvdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class Review implements Parcelable {
    public static final Parcelable.Creator<Review> CREATOR = new Parcelable.Creator<Review>() {
        public Review createFromParcel(Parcel parcel) {
            return new Review(parcel);
        }

        public Review[] newArray(int i2) {
            return new Review[i2];
        }
    };
    @Expose
    private String author;
    @Expose
    private String content;
    @Expose
    private String id;
    @Expose
    private String url;

    public static final class Response {
        @Expose
        public long id;
        @Expose
        public int page;
        @SerializedName("results")
        @Expose
        public List<Review> reviews;
        @SerializedName("total_pages")
        @Expose
        public int totalPages;
        @SerializedName("total_results")
        @Expose
        public int totalResults;
    }

    public Review() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public Review setAuthor(String str) {
        this.author = str;
        return this;
    }

    public Review setContent(String str) {
        this.content = str;
        return this;
    }

    public Review setId(String str) {
        this.id = str;
        return this;
    }

    public Review setUrl(String str) {
        this.url = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.author);
        parcel.writeString(this.content);
        parcel.writeString(this.url);
    }

    protected Review(Parcel parcel) {
        this.id = parcel.readString();
        this.author = parcel.readString();
        this.content = parcel.readString();
        this.url = parcel.readString();
    }
}
