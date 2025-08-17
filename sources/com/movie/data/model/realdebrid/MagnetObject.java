package com.movie.data.model.realdebrid;

import android.os.Parcel;
import android.os.Parcelable;

public class MagnetObject implements Parcelable {
    public static final Parcelable.Creator<MagnetObject> CREATOR = new Parcelable.Creator<MagnetObject>() {
        public MagnetObject createFromParcel(Parcel parcel) {
            return new MagnetObject(parcel);
        }

        public MagnetObject[] newArray(int i2) {
            return new MagnetObject[i2];
        }
    };
    private String cachedStatus;
    private String fileName;
    private String fileSize;
    private String hostName;
    private boolean isPremiumCached = false;
    private int leeks;
    private String magnet;
    private String provider;
    private String quality;
    private int seeds;

    protected MagnetObject(Parcel parcel) {
        boolean z2 = false;
        this.hostName = parcel.readString();
        this.magnet = parcel.readString();
        this.quality = parcel.readString();
        this.fileSize = parcel.readString();
        this.fileName = parcel.readString();
        this.seeds = parcel.readInt();
        this.leeks = parcel.readInt();
        this.isPremiumCached = parcel.readByte() != 0 ? true : z2;
        this.cachedStatus = parcel.readString();
        this.provider = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCachedStatus() {
        return this.cachedStatus;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public String getHostName() {
        return this.hostName;
    }

    public int getLeeks() {
        return this.leeks;
    }

    public String getMagnet() {
        return this.magnet;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getQuality() {
        return this.quality;
    }

    public int getSeeds() {
        return this.seeds;
    }

    public boolean isPremiumCached() {
        return this.isPremiumCached;
    }

    public void setCachedStatus(String str) {
        this.cachedStatus = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setHostName(String str) {
        this.hostName = str;
    }

    public void setLeeks(int i2) {
        this.leeks = i2;
    }

    public void setMagnet(String str) {
        this.magnet = str;
    }

    public void setPremiumCached(boolean z2) {
        this.isPremiumCached = z2;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setSeeds(int i2) {
        this.seeds = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.hostName);
        parcel.writeString(this.magnet);
        parcel.writeString(this.quality);
        parcel.writeString(this.fileSize);
        parcel.writeString(this.fileName);
        parcel.writeInt(this.seeds);
        parcel.writeInt(this.leeks);
        parcel.writeByte(this.isPremiumCached ? (byte) 1 : 0);
        parcel.writeString(this.cachedStatus);
        parcel.writeString(this.provider);
    }

    public MagnetObject(String str, String str2, String str3, String str4) {
        this.hostName = str;
        this.magnet = str2;
        this.quality = str3;
        this.provider = str4;
    }
}
