package com.database.entitys.premiumEntitys;

import android.os.Parcel;
import android.os.Parcelable;

public class RealDebridEntity implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RealDebridEntity> CREATOR = new Parcelable.Creator<RealDebridEntity>() {
        /* renamed from: a */
        public RealDebridEntity createFromParcel(Parcel parcel) {
            return new RealDebridEntity(parcel);
        }

        /* renamed from: b */
        public RealDebridEntity[] newArray(int i2) {
            return new RealDebridEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private long f19326b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f19327c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f19328d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f19329e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f19330f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f19331g = -1;

    /* renamed from: h  reason: collision with root package name */
    private double f19332h;

    /* renamed from: i  reason: collision with root package name */
    private String f19333i;

    /* renamed from: j  reason: collision with root package name */
    private String f19334j;

    /* renamed from: k  reason: collision with root package name */
    private String f19335k;

    /* renamed from: l  reason: collision with root package name */
    private String f19336l;

    /* renamed from: m  reason: collision with root package name */
    private long f19337m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f19338n = true;

    /* renamed from: o  reason: collision with root package name */
    private String f19339o;

    public RealDebridEntity() {
    }

    /* renamed from: b */
    public RealDebridEntity clone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        Parcel obtain2 = Parcel.obtain();
        obtain2.unmarshall(marshall, 0, marshall.length);
        obtain2.setDataPosition(0);
        return CREATOR.createFromParcel(obtain2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19334j);
        parcel.writeLong(this.f19326b);
        parcel.writeString(this.f19327c);
        parcel.writeLong(this.f19328d);
        parcel.writeLong(this.f19329e);
        parcel.writeInt(this.f19330f);
        parcel.writeInt(this.f19331g);
        parcel.writeDouble(this.f19332h);
        parcel.writeString(this.f19333i);
        parcel.writeString(this.f19335k);
        parcel.writeString(this.f19336l);
        parcel.writeLong(this.f19337m);
        parcel.writeString(this.f19339o);
    }

    protected RealDebridEntity(Parcel parcel) {
        this.f19334j = parcel.readString();
        this.f19326b = parcel.readLong();
        this.f19327c = parcel.readString();
        this.f19328d = parcel.readLong();
        this.f19329e = parcel.readLong();
        this.f19330f = parcel.readInt();
        this.f19331g = parcel.readInt();
        this.f19332h = parcel.readDouble();
        this.f19333i = parcel.readString();
        this.f19335k = parcel.readString();
        this.f19336l = parcel.readString();
        this.f19337m = parcel.readLong();
        this.f19339o = parcel.readString();
    }
}
