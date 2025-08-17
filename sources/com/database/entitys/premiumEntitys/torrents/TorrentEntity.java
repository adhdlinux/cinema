package com.database.entitys.premiumEntitys.torrents;

import android.os.Parcel;
import android.os.Parcelable;
import com.movie.data.model.TorrentObject;
import java.util.List;

public class TorrentEntity implements Parcelable {
    public static final Parcelable.Creator<TorrentEntity> CREATOR = new Parcelable.Creator<TorrentEntity>() {
        /* renamed from: a */
        public TorrentEntity createFromParcel(Parcel parcel) {
            return new TorrentEntity(parcel);
        }

        /* renamed from: b */
        public TorrentEntity[] newArray(int i2) {
            return new TorrentEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    String f19347b;

    /* renamed from: c  reason: collision with root package name */
    String f19348c;

    /* renamed from: d  reason: collision with root package name */
    TorrentObject.Type f19349d;

    /* renamed from: e  reason: collision with root package name */
    List<String> f19350e;

    /* renamed from: f  reason: collision with root package name */
    int f19351f;

    public TorrentEntity() {
    }

    public List<String> b() {
        return this.f19350e;
    }

    public String c() {
        return this.f19347b;
    }

    public String d() {
        return this.f19348c;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f19351f;
    }

    public TorrentObject.Type f() {
        return this.f19349d;
    }

    public void g(List<String> list) {
        this.f19350e = list;
    }

    public void h(String str) {
        this.f19347b = str;
    }

    public void i(String str) {
        this.f19348c = str;
    }

    public void j(int i2) {
        this.f19351f = i2;
    }

    public void k(TorrentObject.Type type) {
        this.f19349d = type;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19347b);
        parcel.writeString(this.f19348c);
        parcel.writeStringList(this.f19350e);
        parcel.writeInt(this.f19351f);
    }

    protected TorrentEntity(Parcel parcel) {
        this.f19347b = parcel.readString();
        this.f19348c = parcel.readString();
        this.f19350e = parcel.createStringArrayList();
        this.f19351f = parcel.readInt();
    }
}
