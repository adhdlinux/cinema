package com.movie.data.model.tmvdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.util.List;

public final class Series implements Parcelable {
    public static final Parcelable.Creator<Series> CREATOR = new Parcelable.Creator<Series>() {
        public Series createFromParcel(Parcel parcel) {
            return new Series(parcel);
        }

        public Series[] newArray(int i2) {
            return new Series[i2];
        }
    };
    @Expose
    private int ep;
    @Expose
    private String ggLinkID;
    @Expose
    private String subtitle;

    public static final class Response {
        @Expose
        public List<Series> chaps;
    }

    public Series() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.ep + "-" + this.ggLinkID;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.ep);
        parcel.writeString(this.ggLinkID);
        parcel.writeString(this.subtitle);
    }

    protected Series(Parcel parcel) {
        this.ep = parcel.readInt();
        this.ggLinkID = parcel.readString();
        this.subtitle = parcel.readString();
    }
}
