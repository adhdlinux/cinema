package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new Parcelable.Creator<MlltFrame>() {
        /* renamed from: a */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        /* renamed from: b */
        public MlltFrame[] newArray(int i2) {
            return new MlltFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final int f8333c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8334d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8335e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f8336f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f8337g;

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f8333c = i2;
        this.f8334d = i3;
        this.f8335e = i4;
        this.f8336f = iArr;
        this.f8337g = iArr2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        if (this.f8333c == mlltFrame.f8333c && this.f8334d == mlltFrame.f8334d && this.f8335e == mlltFrame.f8335e && Arrays.equals(this.f8336f, mlltFrame.f8336f) && Arrays.equals(this.f8337g, mlltFrame.f8337g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f8333c) * 31) + this.f8334d) * 31) + this.f8335e) * 31) + Arrays.hashCode(this.f8336f)) * 31) + Arrays.hashCode(this.f8337g);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8333c);
        parcel.writeInt(this.f8334d);
        parcel.writeInt(this.f8335e);
        parcel.writeIntArray(this.f8336f);
        parcel.writeIntArray(this.f8337g);
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f8333c = parcel.readInt();
        this.f8334d = parcel.readInt();
        this.f8335e = parcel.readInt();
        this.f8336f = (int[]) Util.i(parcel.createIntArray());
        this.f8337g = (int[]) Util.i(parcel.createIntArray());
    }
}
