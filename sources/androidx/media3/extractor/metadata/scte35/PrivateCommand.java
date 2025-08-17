package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;

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
    public final long f8357b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8358c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f8359d;

    static PrivateCommand b(ParsableByteArray parsableByteArray, int i2, long j2) {
        long J = parsableByteArray.J();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new PrivateCommand(J, bArr, j2);
    }

    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f8357b + ", identifier= " + this.f8358c + " }";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8357b);
        parcel.writeLong(this.f8358c);
        parcel.writeByteArray(this.f8359d);
    }

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f8357b = j3;
        this.f8358c = j2;
        this.f8359d = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f8357b = parcel.readLong();
        this.f8358c = parcel.readLong();
        this.f8359d = (byte[]) Util.i(parcel.createByteArray());
    }
}
