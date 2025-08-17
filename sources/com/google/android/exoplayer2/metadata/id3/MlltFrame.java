package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
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
    public final int f25432c;

    /* renamed from: d  reason: collision with root package name */
    public final int f25433d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25434e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f25435f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f25436g;

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f25432c = i2;
        this.f25433d = i3;
        this.f25434e = i4;
        this.f25435f = iArr;
        this.f25436g = iArr2;
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
        if (this.f25432c == mlltFrame.f25432c && this.f25433d == mlltFrame.f25433d && this.f25434e == mlltFrame.f25434e && Arrays.equals(this.f25435f, mlltFrame.f25435f) && Arrays.equals(this.f25436g, mlltFrame.f25436g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f25432c) * 31) + this.f25433d) * 31) + this.f25434e) * 31) + Arrays.hashCode(this.f25435f)) * 31) + Arrays.hashCode(this.f25436g);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f25432c);
        parcel.writeInt(this.f25433d);
        parcel.writeInt(this.f25434e);
        parcel.writeIntArray(this.f25435f);
        parcel.writeIntArray(this.f25436g);
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f25432c = parcel.readInt();
        this.f25433d = parcel.readInt();
        this.f25434e = parcel.readInt();
        this.f25435f = (int[]) Util.j(parcel.createIntArray());
        this.f25436g = (int[]) Util.j(parcel.createIntArray());
    }
}
