package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
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
    public final byte[] f8304c;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f8304c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (!this.f8328b.equals(binaryFrame.f8328b) || !Arrays.equals(this.f8304c, binaryFrame.f8304c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f8328b.hashCode()) * 31) + Arrays.hashCode(this.f8304c);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8328b);
        parcel.writeByteArray(this.f8304c);
    }

    BinaryFrame(Parcel parcel) {
        super((String) Util.i(parcel.readString()));
        this.f8304c = (byte[]) Util.i(parcel.createByteArray());
    }
}
