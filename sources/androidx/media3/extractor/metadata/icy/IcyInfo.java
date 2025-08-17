package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Assertions;
import java.util.Arrays;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        /* renamed from: a */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        /* renamed from: b */
        public IcyInfo[] newArray(int i2) {
            return new IcyInfo[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f8297b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8298c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8299d;

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.f8297b = bArr;
        this.f8298c = str;
        this.f8299d = str2;
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public void H(MediaMetadata.Builder builder) {
        String str = this.f8298c;
        if (str != null) {
            builder.o0(str);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8297b, ((IcyInfo) obj).f8297b);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8297b);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.f8298c, this.f8299d, Integer.valueOf(this.f8297b.length)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f8297b);
        parcel.writeString(this.f8298c);
        parcel.writeString(this.f8299d);
    }

    IcyInfo(Parcel parcel) {
        this.f8297b = (byte[]) Assertions.f(parcel.createByteArray());
        this.f8298c = parcel.readString();
        this.f8299d = parcel.readString();
    }
}
