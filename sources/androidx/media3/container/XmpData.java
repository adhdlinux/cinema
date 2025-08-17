package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Util;
import java.util.Arrays;

public final class XmpData implements Metadata.Entry {
    public static final Parcelable.Creator<XmpData> CREATOR = new Parcelable.Creator<XmpData>() {
        /* renamed from: a */
        public XmpData createFromParcel(Parcel parcel) {
            return new XmpData(parcel);
        }

        /* renamed from: b */
        public XmpData[] newArray(int i2) {
            return new XmpData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4796b;

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
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f4796b, ((XmpData) obj).f4796b);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4796b);
    }

    public String toString() {
        return "XMP: " + Util.p1(this.f4796b);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f4796b);
    }

    private XmpData(Parcel parcel) {
        this.f4796b = (byte[]) Util.i(parcel.createByteArray());
    }
}
