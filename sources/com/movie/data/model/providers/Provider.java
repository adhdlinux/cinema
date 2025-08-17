package com.movie.data.model.providers;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Provider implements Parcelable {
    public static final Parcelable.Creator<Provider> CREATOR = new Parcelable.Creator<Provider>() {
        public Provider createFromParcel(Parcel parcel) {
            return new Provider(parcel);
        }

        public Provider[] newArray(int i2) {
            return new Provider[i2];
        }
    };
    private String domain;
    private String name;
    private String src;
    private List<String> type;
    private String url;
    private String version;

    protected Provider(Parcel parcel) {
        this.name = parcel.readString();
        this.domain = parcel.readString();
        this.version = parcel.readString();
        this.url = parcel.readString();
        this.type = parcel.createStringArrayList();
        this.src = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getName() {
        return this.name;
    }

    public String getSrc() {
        return this.src;
    }

    public List<String> getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setType(List<String> list) {
        this.type = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "Provider{name='" + this.name + '\'' + ", domain='" + this.domain + '\'' + ", version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", type=" + this.type + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.domain);
        parcel.writeString(this.version);
        parcel.writeString(this.url);
        parcel.writeStringList(this.type);
        parcel.writeString(this.src);
    }
}
