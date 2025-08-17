package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;
import org.threeten.bp.OffsetDateTime;

public class TvWatchedEpisode implements Parcelable {
    public static final Parcelable.Creator<TvWatchedEpisode> CREATOR = new Parcelable.Creator<TvWatchedEpisode>() {
        /* renamed from: a */
        public TvWatchedEpisode createFromParcel(Parcel parcel) {
            return new TvWatchedEpisode(parcel);
        }

        /* renamed from: b */
        public TvWatchedEpisode[] newArray(int i2) {
            return new TvWatchedEpisode[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f19308b;

    /* renamed from: c  reason: collision with root package name */
    private long f19309c;

    /* renamed from: d  reason: collision with root package name */
    private String f19310d;

    /* renamed from: e  reason: collision with root package name */
    private long f19311e;

    /* renamed from: f  reason: collision with root package name */
    private long f19312f;

    /* renamed from: g  reason: collision with root package name */
    private int f19313g;

    /* renamed from: h  reason: collision with root package name */
    private int f19314h;

    /* renamed from: i  reason: collision with root package name */
    private long f19315i;

    /* renamed from: j  reason: collision with root package name */
    private long f19316j;

    /* renamed from: k  reason: collision with root package name */
    private String f19317k;

    /* renamed from: l  reason: collision with root package name */
    private OffsetDateTime f19318l;

    /* renamed from: m  reason: collision with root package name */
    private OffsetDateTime f19319m;

    protected TvWatchedEpisode(Parcel parcel) {
        this.f19308b = parcel.readInt();
        this.f19309c = parcel.readLong();
        this.f19310d = parcel.readString();
        this.f19311e = parcel.readLong();
        this.f19312f = parcel.readLong();
        this.f19313g = parcel.readInt();
        this.f19314h = parcel.readInt();
        this.f19315i = parcel.readLong();
        this.f19316j = parcel.readLong();
        this.f19317k = parcel.readString();
    }

    public long b() {
        return this.f19316j;
    }

    public int c() {
        return this.f19314h;
    }

    public String d() {
        return this.f19310d;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f19315i;
    }

    public int f() {
        return this.f19313g;
    }

    public String g() {
        return this.f19317k;
    }

    public long h() {
        return this.f19309c;
    }

    public long i() {
        return this.f19312f;
    }

    public long j() {
        return this.f19311e;
    }

    public void k(OffsetDateTime offsetDateTime) {
        this.f19318l = offsetDateTime;
    }

    public void l(long j2) {
        this.f19316j = j2;
    }

    public void m(int i2) {
        this.f19314h = i2;
    }

    public void n(int i2) {
        this.f19308b = i2;
    }

    public void o(String str) {
        this.f19310d = str;
    }

    public void p(long j2) {
        this.f19315i = j2;
    }

    public void q(int i2) {
        this.f19313g = i2;
    }

    public void r(String str) {
        this.f19317k = str;
    }

    public void s(long j2) {
        this.f19309c = j2;
    }

    public void t(long j2) {
        this.f19312f = j2;
    }

    public void u(long j2) {
        this.f19311e = j2;
    }

    public void v(OffsetDateTime offsetDateTime) {
        this.f19319m = offsetDateTime;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19308b);
        parcel.writeLong(this.f19309c);
        parcel.writeString(this.f19310d);
        parcel.writeLong(this.f19311e);
        parcel.writeLong(this.f19312f);
        parcel.writeInt(this.f19313g);
        parcel.writeInt(this.f19314h);
        parcel.writeLong(this.f19315i);
        parcel.writeLong(this.f19316j);
        parcel.writeString(this.f19317k);
    }

    public TvWatchedEpisode() {
    }
}
