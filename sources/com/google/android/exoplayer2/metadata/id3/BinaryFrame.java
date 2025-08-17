package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        /* renamed from: b */
        public BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f25404c;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f25404c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (!this.f25428b.equals(binaryFrame.f25428b) || !Arrays.equals(this.f25404c, binaryFrame.f25404c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f25428b.hashCode()) * 31) + Arrays.hashCode(this.f25404c);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25428b);
        parcel.writeByteArray(this.f25404c);
    }

    BinaryFrame(Parcel parcel) {
        super((String) Util.j(parcel.readString()));
        this.f25404c = (byte[]) Util.j(parcel.createByteArray());
    }
}
