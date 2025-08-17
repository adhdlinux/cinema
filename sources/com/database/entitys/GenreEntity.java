package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;

public class GenreEntity implements Parcelable {
    public static final Parcelable.Creator<GenreEntity> CREATOR = new Parcelable.Creator<GenreEntity>() {
        /* renamed from: a */
        public GenreEntity createFromParcel(Parcel parcel) {
            return new GenreEntity(parcel);
        }

        /* renamed from: b */
        public GenreEntity[] newArray(int i2) {
            return new GenreEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f19295b;

    /* renamed from: c  reason: collision with root package name */
    private String f19296c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19297d;

    /* renamed from: e  reason: collision with root package name */
    private String f19298e;

    public GenreEntity() {
    }

    public void b(int i2) {
        this.f19295b = i2;
    }

    public void c(String str) {
        this.f19296c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19295b);
        parcel.writeString(this.f19296c);
        parcel.writeByte(this.f19297d ? (byte) 1 : 0);
        parcel.writeString(this.f19298e);
    }

    protected GenreEntity(Parcel parcel) {
        this.f19295b = parcel.readInt();
        this.f19296c = parcel.readString();
        this.f19297d = parcel.readByte() != 0;
        this.f19298e = parcel.readString();
    }
}
