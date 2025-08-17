package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* renamed from: b */
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25400c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25401d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25402e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f25403f;

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f25400c = str;
        this.f25401d = str2;
        this.f25402e = i2;
        this.f25403f = bArr;
    }

    public void a(MediaMetadata.Builder builder) {
        builder.I(this.f25403f, this.f25402e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.f25402e != apicFrame.f25402e || !Util.c(this.f25400c, apicFrame.f25400c) || !Util.c(this.f25401d, apicFrame.f25401d) || !Arrays.equals(this.f25403f, apicFrame.f25403f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3 = (527 + this.f25402e) * 31;
        String str = this.f25400c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i3 + i2) * 31;
        String str2 = this.f25401d;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((i5 + i4) * 31) + Arrays.hashCode(this.f25403f);
    }

    public String toString() {
        return this.f25428b + ": mimeType=" + this.f25400c + ", description=" + this.f25401d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25400c);
        parcel.writeString(this.f25401d);
        parcel.writeInt(this.f25402e);
        parcel.writeByteArray(this.f25403f);
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f25400c = (String) Util.j(parcel.readString());
        this.f25401d = parcel.readString();
        this.f25402e = parcel.readInt();
        this.f25403f = (byte[]) Util.j(parcel.createByteArray());
    }
}
