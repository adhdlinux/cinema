package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.util.Arrays;

public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new Parcelable.Creator<PictureFrame>() {
        /* renamed from: a */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        /* renamed from: b */
        public PictureFrame[] newArray(int i2) {
            return new PictureFrame[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f25378b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25379c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25380d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25381e;

    /* renamed from: f  reason: collision with root package name */
    public final int f25382f;

    /* renamed from: g  reason: collision with root package name */
    public final int f25383g;

    /* renamed from: h  reason: collision with root package name */
    public final int f25384h;

    /* renamed from: i  reason: collision with root package name */
    public final byte[] f25385i;

    public PictureFrame(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f25378b = i2;
        this.f25379c = str;
        this.f25380d = str2;
        this.f25381e = i3;
        this.f25382f = i4;
        this.f25383g = i5;
        this.f25384h = i6;
        this.f25385i = bArr;
    }

    public static PictureFrame b(ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        String F = parsableByteArray.F(parsableByteArray.q(), Charsets.US_ASCII);
        String E = parsableByteArray.E(parsableByteArray.q());
        int q3 = parsableByteArray.q();
        int q4 = parsableByteArray.q();
        int q5 = parsableByteArray.q();
        int q6 = parsableByteArray.q();
        int q7 = parsableByteArray.q();
        byte[] bArr = new byte[q7];
        parsableByteArray.l(bArr, 0, q7);
        return new PictureFrame(q2, F, E, q3, q4, q5, q6, bArr);
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public void a(MediaMetadata.Builder builder) {
        builder.I(this.f25385i, this.f25378b);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        if (this.f25378b == pictureFrame.f25378b && this.f25379c.equals(pictureFrame.f25379c) && this.f25380d.equals(pictureFrame.f25380d) && this.f25381e == pictureFrame.f25381e && this.f25382f == pictureFrame.f25382f && this.f25383g == pictureFrame.f25383g && this.f25384h == pictureFrame.f25384h && Arrays.equals(this.f25385i, pictureFrame.f25385i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f25378b) * 31) + this.f25379c.hashCode()) * 31) + this.f25380d.hashCode()) * 31) + this.f25381e) * 31) + this.f25382f) * 31) + this.f25383g) * 31) + this.f25384h) * 31) + Arrays.hashCode(this.f25385i);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f25379c + ", description=" + this.f25380d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f25378b);
        parcel.writeString(this.f25379c);
        parcel.writeString(this.f25380d);
        parcel.writeInt(this.f25381e);
        parcel.writeInt(this.f25382f);
        parcel.writeInt(this.f25383g);
        parcel.writeInt(this.f25384h);
        parcel.writeByteArray(this.f25385i);
    }

    PictureFrame(Parcel parcel) {
        this.f25378b = parcel.readInt();
        this.f25379c = (String) Util.j(parcel.readString());
        this.f25380d = (String) Util.j(parcel.readString());
        this.f25381e = parcel.readInt();
        this.f25382f = parcel.readInt();
        this.f25383g = parcel.readInt();
        this.f25384h = parcel.readInt();
        this.f25385i = (byte[]) Util.j(parcel.createByteArray());
    }
}
