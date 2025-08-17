package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

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

    /* renamed from: e  reason: collision with root package name */
    private static final String f4336e = Util.B0(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f4337f = Util.B0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f4338g = Util.B0(2);

    /* renamed from: b  reason: collision with root package name */
    public final int f4339b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4340c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4341d;

    public StreamKey(int i2, int i3, int i4) {
        this.f4339b = i2;
        this.f4340c = i3;
        this.f4341d = i4;
    }

    /* renamed from: b */
    public int compareTo(StreamKey streamKey) {
        int i2 = this.f4339b - streamKey.f4339b;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f4340c - streamKey.f4340c;
        if (i3 == 0) {
            return this.f4341d - streamKey.f4341d;
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
        if (this.f4339b == streamKey.f4339b && this.f4340c == streamKey.f4340c && this.f4341d == streamKey.f4341d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f4339b * 31) + this.f4340c) * 31) + this.f4341d;
    }

    public String toString() {
        return this.f4339b + "." + this.f4340c + "." + this.f4341d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4339b);
        parcel.writeInt(this.f4340c);
        parcel.writeInt(this.f4341d);
    }

    StreamKey(Parcel parcel) {
        this.f4339b = parcel.readInt();
        this.f4340c = parcel.readInt();
        this.f4341d = parcel.readInt();
    }
}
