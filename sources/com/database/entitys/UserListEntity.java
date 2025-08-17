package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;

public class UserListEntity implements Parcelable {
    public static final Parcelable.Creator<UserListEntity> CREATOR = new Parcelable.Creator<UserListEntity>() {
        /* renamed from: a */
        public UserListEntity createFromParcel(Parcel parcel) {
            return new UserListEntity(parcel);
        }

        /* renamed from: b */
        public UserListEntity[] newArray(int i2) {
            return new UserListEntity[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public String f19320b;

    /* renamed from: c  reason: collision with root package name */
    public String f19321c;

    /* renamed from: d  reason: collision with root package name */
    public String f19322d;

    /* renamed from: e  reason: collision with root package name */
    public String f19323e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19324f = true;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f19325g = Boolean.FALSE;

    public UserListEntity(String str, String str2, String str3, String str4) {
        this.f19320b = str;
        this.f19321c = str2;
        this.f19322d = str3;
        this.f19323e = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19320b);
        parcel.writeString(this.f19321c);
        parcel.writeString(this.f19322d);
        parcel.writeString(this.f19323e);
    }

    protected UserListEntity(Parcel parcel) {
        this.f19320b = parcel.readString();
        this.f19321c = parcel.readString();
        this.f19322d = parcel.readString();
        this.f19323e = parcel.readString();
    }
}
