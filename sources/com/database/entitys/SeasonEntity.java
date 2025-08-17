package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;

public class SeasonEntity implements Parcelable, Comparable<SeasonEntity> {
    public static final Parcelable.Creator<SeasonEntity> CREATOR = new Parcelable.Creator<SeasonEntity>() {
        /* renamed from: a */
        public SeasonEntity createFromParcel(Parcel parcel) {
            return new SeasonEntity(parcel);
        }

        /* renamed from: b */
        public SeasonEntity[] newArray(int i2) {
            return new SeasonEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f19299b;

    /* renamed from: c  reason: collision with root package name */
    private int f19300c;

    /* renamed from: d  reason: collision with root package name */
    private int f19301d;

    /* renamed from: e  reason: collision with root package name */
    private String f19302e;

    /* renamed from: f  reason: collision with root package name */
    private String f19303f;

    /* renamed from: g  reason: collision with root package name */
    private String f19304g;

    /* renamed from: h  reason: collision with root package name */
    private int f19305h;

    /* renamed from: i  reason: collision with root package name */
    private double f19306i;

    /* renamed from: j  reason: collision with root package name */
    private String f19307j;

    protected SeasonEntity(Parcel parcel) {
        this.f19299b = parcel.readInt();
        this.f19300c = parcel.readInt();
        this.f19301d = parcel.readInt();
        this.f19302e = parcel.readString();
        this.f19303f = parcel.readString();
        this.f19304g = parcel.readString();
        this.f19305h = parcel.readInt();
        this.f19306i = parcel.readDouble();
        this.f19307j = parcel.readString();
    }

    /* renamed from: b */
    public int compareTo(SeasonEntity seasonEntity) {
        return j() > seasonEntity.j() ? 1 : -1;
    }

    public String c() {
        return this.f19303f;
    }

    public int d() {
        return this.f19300c;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f19299b;
    }

    public int f() {
        return this.f19305h;
    }

    public String g() {
        return this.f19307j;
    }

    public String h() {
        return this.f19304g;
    }

    public String i() {
        return this.f19302e;
    }

    public int j() {
        return this.f19301d;
    }

    public void k(String str) {
        this.f19303f = str;
    }

    public void l(int i2) {
        this.f19300c = i2;
    }

    public void m(int i2) {
        this.f19299b = i2;
    }

    public void n(int i2) {
        this.f19305h = i2;
    }

    public void o(String str) {
        this.f19307j = str;
    }

    public void p(String str) {
        this.f19304g = str;
    }

    public void q(String str) {
        this.f19302e = str;
    }

    public void r(int i2) {
        this.f19301d = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19299b);
        parcel.writeInt(this.f19300c);
        parcel.writeInt(this.f19301d);
        parcel.writeString(this.f19302e);
        parcel.writeString(this.f19303f);
        parcel.writeString(this.f19304g);
        parcel.writeInt(this.f19305h);
        parcel.writeDouble(this.f19306i);
        parcel.writeString(this.f19307j);
    }

    public SeasonEntity() {
    }
}
