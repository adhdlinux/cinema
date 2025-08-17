package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;

public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        /* renamed from: a */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        /* renamed from: b */
        public StreamKey[] newArray(int i2) {
            return new StreamKey[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f25636b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25637c;

    /* renamed from: d  reason: collision with root package name */
    public final int f25638d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public final int f25639e;

    public StreamKey(int i2, int i3, int i4) {
        this.f25636b = i2;
        this.f25637c = i3;
        this.f25638d = i4;
        this.f25639e = i4;
    }

    /* renamed from: b */
    public int compareTo(StreamKey streamKey) {
        int i2 = this.f25636b - streamKey.f25636b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f25637c - streamKey.f25637c;
        if (i3 == 0) {
            return this.f25638d - streamKey.f25638d;
        }
        return i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.f25636b == streamKey.f25636b && this.f25637c == streamKey.f25637c && this.f25638d == streamKey.f25638d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f25636b * 31) + this.f25637c) * 31) + this.f25638d;
    }

    public String toString() {
        return this.f25636b + "." + this.f25637c + "." + this.f25638d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f25636b);
        parcel.writeInt(this.f25637c);
        parcel.writeInt(this.f25638d);
    }

    StreamKey(Parcel parcel) {
        this.f25636b = parcel.readInt();
        this.f25637c = parcel.readInt();
        int readInt = parcel.readInt();
        this.f25638d = readInt;
        this.f25639e = readInt;
    }
}
