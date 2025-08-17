package com.startapp;

import android.os.Parcel;
import android.os.Parcelable;

public class o4 extends d4 {
    public static final Parcelable.Creator<o4> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public float f35549f;

    /* renamed from: g  reason: collision with root package name */
    public float f35550g;

    public static class a implements Parcelable.Creator<o4> {
        public Object createFromParcel(Parcel parcel) {
            return new o4(parcel);
        }

        public Object[] newArray(int i2) {
            return new o4[i2];
        }
    }

    public o4(float f2, float f3) {
        this.f35549f = f2;
        this.f35550g = f3;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return super.toString() + ", Friction: [" + this.f35549f + "], Snap:[" + this.f35550g + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f34337a);
        parcel.writeFloat(this.f34338b);
        parcel.writeFloat(this.f34339c);
        parcel.writeFloat(this.f34340d);
        parcel.writeFloat(this.f35549f);
        parcel.writeFloat(this.f35550g);
    }

    public o4(Parcel parcel) {
        super(parcel);
        this.f35549f = parcel.readFloat();
        this.f35550g = parcel.readFloat();
    }
}
