package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        /* renamed from: b */
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25437c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f25438d;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f25437c = str;
        this.f25438d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (!Util.c(this.f25437c, privFrame.f25437c) || !Arrays.equals(this.f25438d, privFrame.f25438d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.f25437c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return ((527 + i2) * 31) + Arrays.hashCode(this.f25438d);
    }

    public String toString() {
        return this.f25428b + ": owner=" + this.f25437c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25437c);
        parcel.writeByteArray(this.f25438d);
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f25437c = (String) Util.j(parcel.readString());
        this.f25438d = (byte[]) Util.j(parcel.createByteArray());
    }
}
