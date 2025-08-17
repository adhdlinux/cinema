package com.database.entitys.premiumEntitys.torrents;

import android.os.Parcel;
import android.os.Parcelable;
import com.movie.data.model.TorrentObject;

public class CachedTorrentFileEntity implements Parcelable {
    public static final Parcelable.Creator<CachedTorrentFileEntity> CREATOR = new Parcelable.Creator<CachedTorrentFileEntity>() {
        /* renamed from: a */
        public CachedTorrentFileEntity createFromParcel(Parcel parcel) {
            return new CachedTorrentFileEntity(parcel);
        }

        /* renamed from: b */
        public CachedTorrentFileEntity[] newArray(int i2) {
            return new CachedTorrentFileEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private String f19340b;

    /* renamed from: c  reason: collision with root package name */
    private String f19341c;

    /* renamed from: d  reason: collision with root package name */
    private long f19342d;

    /* renamed from: e  reason: collision with root package name */
    private int f19343e;

    /* renamed from: f  reason: collision with root package name */
    private int f19344f;

    /* renamed from: g  reason: collision with root package name */
    private int f19345g;

    /* renamed from: h  reason: collision with root package name */
    TorrentObject.Type f19346h;

    public CachedTorrentFileEntity() {
    }

    public int b() {
        return this.f19345g;
    }

    public long c() {
        return this.f19342d;
    }

    public String d() {
        return this.f19341c;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f19340b;
    }

    public int f() {
        return this.f19343e;
    }

    public int g() {
        return this.f19344f;
    }

    public TorrentObject.Type h() {
        return this.f19346h;
    }

    public void i(int i2) {
        this.f19345g = i2;
    }

    public void j(long j2) {
        this.f19342d = j2;
    }

    public void k(String str) {
        this.f19341c = str;
    }

    public void l(String str) {
        this.f19340b = str;
    }

    public void m(int i2) {
        this.f19343e = i2;
    }

    public void n(int i2) {
        this.f19344f = i2;
    }

    public void o(TorrentObject.Type type) {
        this.f19346h = type;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19340b);
        parcel.writeString(this.f19341c);
        parcel.writeLong(this.f19342d);
        parcel.writeInt(this.f19343e);
        parcel.writeInt(this.f19344f);
        parcel.writeInt(this.f19345g);
    }

    protected CachedTorrentFileEntity(Parcel parcel) {
        this.f19340b = parcel.readString();
        this.f19341c = parcel.readString();
        this.f19342d = parcel.readLong();
        this.f19343e = parcel.readInt();
        this.f19344f = parcel.readInt();
        this.f19345g = parcel.readInt();
    }
}
