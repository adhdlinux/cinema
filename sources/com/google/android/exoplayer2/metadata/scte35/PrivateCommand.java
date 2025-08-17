package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* renamed from: b */
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final long f25460b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25461c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f25462d;

    static PrivateCommand b(ParsableByteArray parsableByteArray, int i2, long j2) {
        long J = parsableByteArray.J();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new PrivateCommand(J, bArr, j2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f25460b);
        parcel.writeLong(this.f25461c);
        parcel.writeByteArray(this.f25462d);
    }

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f25460b = j3;
        this.f25461c = j2;
        this.f25462d = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f25460b = parcel.readLong();
        this.f25461c = parcel.readLong();
        this.f25462d = (byte[]) Util.j(parcel.createByteArray());
    }
}
