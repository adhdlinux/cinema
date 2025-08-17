package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: b */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25419c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25420d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25421e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f25422f;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f25419c = str;
        this.f25420d = str2;
        this.f25421e = str3;
        this.f25422f = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (!Util.c(this.f25419c, geobFrame.f25419c) || !Util.c(this.f25420d, geobFrame.f25420d) || !Util.c(this.f25421e, geobFrame.f25421e) || !Arrays.equals(this.f25422f, geobFrame.f25422f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f25419c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f25420d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f25421e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return ((i6 + i4) * 31) + Arrays.hashCode(this.f25422f);
    }

    public String toString() {
        return this.f25428b + ": mimeType=" + this.f25419c + ", filename=" + this.f25420d + ", description=" + this.f25421e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25419c);
        parcel.writeString(this.f25420d);
        parcel.writeString(this.f25421e);
        parcel.writeByteArray(this.f25422f);
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f25419c = (String) Util.j(parcel.readString());
        this.f25420d = (String) Util.j(parcel.readString());
        this.f25421e = (String) Util.j(parcel.readString());
        this.f25422f = (byte[]) Util.j(parcel.createByteArray());
    }
}
