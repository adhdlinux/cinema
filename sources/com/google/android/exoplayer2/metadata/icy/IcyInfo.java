package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        /* renamed from: a */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        /* renamed from: b */
        public IcyInfo[] newArray(int i2) {
            return new IcyInfo[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f25397b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25398c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25399d;

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.f25397b = bArr;
        this.f25398c = str;
        this.f25399d = str2;
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public void a(MediaMetadata.Builder builder) {
        String str = this.f25398c;
        if (str != null) {
            builder.m0(str);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f25397b, ((IcyInfo) obj).f25397b);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f25397b);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.f25398c, this.f25399d, Integer.valueOf(this.f25397b.length)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f25397b);
        parcel.writeString(this.f25398c);
        parcel.writeString(this.f25399d);
    }

    IcyInfo(Parcel parcel) {
        this.f25397b = (byte[]) Assertions.e(parcel.createByteArray());
        this.f25398c = parcel.readString();
        this.f25399d = parcel.readString();
    }
}
