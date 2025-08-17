package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: b */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f8319c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8320d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8321e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f8322f;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f8319c = str;
        this.f8320d = str2;
        this.f8321e = str3;
        this.f8322f = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (!Util.c(this.f8319c, geobFrame.f8319c) || !Util.c(this.f8320d, geobFrame.f8320d) || !Util.c(this.f8321e, geobFrame.f8321e) || !Arrays.equals(this.f8322f, geobFrame.f8322f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f8319c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f8320d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f8321e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return ((i6 + i4) * 31) + Arrays.hashCode(this.f8322f);
    }

    public String toString() {
        return this.f8328b + ": mimeType=" + this.f8319c + ", filename=" + this.f8320d + ", description=" + this.f8321e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8319c);
        parcel.writeString(this.f8320d);
        parcel.writeString(this.f8321e);
        parcel.writeByteArray(this.f8322f);
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f8319c = (String) Util.i(parcel.readString());
        this.f8320d = (String) Util.i(parcel.readString());
        this.f8321e = (String) Util.i(parcel.readString());
        this.f8322f = (byte[]) Util.i(parcel.createByteArray());
    }
}
