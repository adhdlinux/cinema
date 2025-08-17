package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        /* renamed from: a */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        /* renamed from: b */
        public MdtaMetadataEntry[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f4738b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4739c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4740d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4741e;

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public /* synthetic */ void H(MediaMetadata.Builder builder) {
        d.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        if (!this.f4738b.equals(mdtaMetadataEntry.f4738b) || !Arrays.equals(this.f4739c, mdtaMetadataEntry.f4739c) || this.f4740d != mdtaMetadataEntry.f4740d || this.f4741e != mdtaMetadataEntry.f4741e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f4738b.hashCode()) * 31) + Arrays.hashCode(this.f4739c)) * 31) + this.f4740d) * 31) + this.f4741e;
    }

    public String toString() {
        String str;
        int i2 = this.f4741e;
        if (i2 == 1) {
            str = Util.H(this.f4739c);
        } else if (i2 == 23) {
            str = String.valueOf(Float.intBitsToFloat(Ints.g(this.f4739c)));
        } else if (i2 != 67) {
            str = Util.p1(this.f4739c);
        } else {
            str = String.valueOf(Ints.g(this.f4739c));
        }
        return "mdta: key=" + this.f4738b + ", value=" + str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4738b);
        parcel.writeByteArray(this.f4739c);
        parcel.writeInt(this.f4740d);
        parcel.writeInt(this.f4741e);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.f4738b = str;
        this.f4739c = bArr;
        this.f4740d = i2;
        this.f4741e = i3;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.f4738b = (String) Util.i(parcel.readString());
        this.f4739c = (byte[]) Util.i(parcel.createByteArray());
        this.f4740d = parcel.readInt();
        this.f4741e = parcel.readInt();
    }
}
