package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Util;
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
    public final String f8300c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8301d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8302e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f8303f;

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f8300c = str;
        this.f8301d = str2;
        this.f8302e = i2;
        this.f8303f = bArr;
    }

    public void H(MediaMetadata.Builder builder) {
        builder.J(this.f8303f, this.f8302e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.f8302e != apicFrame.f8302e || !Util.c(this.f8300c, apicFrame.f8300c) || !Util.c(this.f8301d, apicFrame.f8301d) || !Arrays.equals(this.f8303f, apicFrame.f8303f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3 = (527 + this.f8302e) * 31;
        String str = this.f8300c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i3 + i2) * 31;
        String str2 = this.f8301d;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((i5 + i4) * 31) + Arrays.hashCode(this.f8303f);
    }

    public String toString() {
        return this.f8328b + ": mimeType=" + this.f8300c + ", description=" + this.f8301d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8300c);
        parcel.writeString(this.f8301d);
        parcel.writeInt(this.f8302e);
        parcel.writeByteArray(this.f8303f);
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f8300c = (String) Util.i(parcel.readString());
        this.f8301d = parcel.readString();
        this.f8302e = parcel.readInt();
        this.f8303f = (byte[]) Util.i(parcel.createByteArray());
    }
}
