package com.movie.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class MovieInfo implements Parcelable {
    public static final Parcelable.Creator<MovieInfo> CREATOR = new Parcelable.Creator<MovieInfo>() {
        public MovieInfo createFromParcel(Parcel parcel) {
            return new MovieInfo(parcel);
        }

        public MovieInfo[] newArray(int i2) {
            return new MovieInfo[i2];
        }
    };
    public long cinemaID;
    public String eps;
    public int epsCount;
    public String extension;
    public String fileName;
    public String fileSizeString;
    public List<String> genres;
    public String imdbIDStr;
    public String name;
    public String session;
    public String sessionYear;
    public String subtileLink;
    public String tempStreamLink;
    public long tmdbID;
    public long traktID;
    public long tvdbID;
    public String year;

    protected MovieInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.year = parcel.readString();
        this.session = parcel.readString();
        this.eps = parcel.readString();
        this.sessionYear = parcel.readString();
        this.tempStreamLink = parcel.readString();
        this.extension = parcel.readString();
        this.fileSizeString = parcel.readString();
        this.subtileLink = parcel.readString();
        this.fileName = parcel.readString();
        this.epsCount = parcel.readInt();
        this.tmdbID = parcel.readLong();
        this.imdbIDStr = parcel.readString();
        this.tvdbID = parcel.readLong();
        this.traktID = parcel.readLong();
        this.cinemaID = parcel.readLong();
        this.genres = parcel.createStringArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public Integer getEps() {
        String str = this.eps;
        if (str == null || str.equals("")) {
            return -1;
        }
        return Integer.valueOf(Integer.parseInt(this.eps));
    }

    public String getName() {
        return this.name;
    }

    public String getNameAndYear() {
        return this.name + " " + this.year;
    }

    public Integer getSession() {
        String str = this.session;
        if (str == null || str.equals("")) {
            return -1;
        }
        return Integer.valueOf(Integer.parseInt(this.session));
    }

    public Integer getSessionYear() {
        String str = this.sessionYear;
        if (str == null || str.equals("")) {
            return -1;
        }
        return Integer.valueOf(Integer.parseInt(this.sessionYear));
    }

    public Integer getType() {
        if (getSession().intValue() < 0) {
            return 1;
        }
        return 0;
    }

    public Integer getYear() {
        return Integer.valueOf(Integer.parseInt(this.year));
    }

    public void setImdbIDStr(String str) {
        this.imdbIDStr = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.year);
        parcel.writeString(this.session);
        parcel.writeString(this.eps);
        parcel.writeString(this.sessionYear);
        parcel.writeString(this.tempStreamLink);
        parcel.writeString(this.extension);
        parcel.writeString(this.fileSizeString);
        parcel.writeString(this.subtileLink);
        parcel.writeString(this.fileName);
        parcel.writeInt(this.epsCount);
        parcel.writeLong(this.tmdbID);
        parcel.writeString(this.imdbIDStr);
        parcel.writeLong(this.tvdbID);
        parcel.writeLong(this.traktID);
        parcel.writeLong(this.cinemaID);
        parcel.writeStringList(this.genres);
    }

    public MovieInfo clone() {
        MovieInfo movieInfo = new MovieInfo(this.name, this.year, this.session, this.eps, this.sessionYear);
        movieInfo.tempStreamLink = this.tempStreamLink;
        movieInfo.cinemaID = this.cinemaID;
        movieInfo.tmdbID = this.tmdbID;
        movieInfo.imdbIDStr = this.imdbIDStr;
        movieInfo.tvdbID = this.tvdbID;
        movieInfo.year = this.year;
        movieInfo.session = this.session;
        movieInfo.eps = this.eps;
        movieInfo.sessionYear = this.sessionYear;
        movieInfo.fileSizeString = this.fileSizeString;
        movieInfo.extension = this.extension;
        movieInfo.subtileLink = this.subtileLink;
        movieInfo.fileName = this.fileName;
        movieInfo.genres = this.genres;
        return movieInfo;
    }

    public MovieInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.year = str2;
        this.session = str3;
        this.eps = str4;
        this.sessionYear = str5;
    }

    public MovieInfo(String str, String str2, String str3, String str4, String str5, List<String> list) {
        this.name = str;
        this.year = str2;
        this.session = str3;
        this.eps = str4;
        this.sessionYear = str5;
        this.genres = list;
    }
}
