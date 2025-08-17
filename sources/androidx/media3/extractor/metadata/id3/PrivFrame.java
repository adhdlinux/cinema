package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
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
    public final String f8338c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f8339d;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f8338c = str;
        this.f8339d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (!Util.c(this.f8338c, privFrame.f8338c) || !Arrays.equals(this.f8339d, privFrame.f8339d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.f8338c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return ((527 + i2) * 31) + Arrays.hashCode(this.f8339d);
    }

    public String toString() {
        return this.f8328b + ": owner=" + this.f8338c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8338c);
        parcel.writeByteArray(this.f8339d);
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f8338c = (String) Util.i(parcel.readString());
        this.f8339d = (byte[]) Util.i(parcel.createByteArray());
    }
}
