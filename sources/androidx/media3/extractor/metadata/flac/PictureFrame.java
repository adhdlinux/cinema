package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.d;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.util.Arrays;

public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new Parcelable.Creator<PictureFrame>() {
        /* renamed from: a */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        /* renamed from: b */
        public PictureFrame[] newArray(int i2) {
            return new PictureFrame[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f8278b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8279c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8280d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8281e;

    /* renamed from: f  reason: collision with root package name */
    public final int f8282f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8283g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8284h;

    /* renamed from: i  reason: collision with root package name */
    public final byte[] f8285i;

    public PictureFrame(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f8278b = i2;
        this.f8279c = str;
        this.f8280d = str2;
        this.f8281e = i3;
        this.f8282f = i4;
        this.f8283g = i5;
        this.f8284h = i6;
        this.f8285i = bArr;
    }

    public static PictureFrame b(ParsableByteArray parsableByteArray) {
        int q2 = parsableByteArray.q();
        String t2 = MimeTypes.t(parsableByteArray.F(parsableByteArray.q(), Charsets.US_ASCII));
        String E = parsableByteArray.E(parsableByteArray.q());
        int q3 = parsableByteArray.q();
        int q4 = parsableByteArray.q();
        int q5 = parsableByteArray.q();
        int q6 = parsableByteArray.q();
        int q7 = parsableByteArray.q();
        byte[] bArr = new byte[q7];
        parsableByteArray.l(bArr, 0, q7);
        return new PictureFrame(q2, t2, E, q3, q4, q5, q6, bArr);
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public void H(MediaMetadata.Builder builder) {
        builder.J(this.f8285i, this.f8278b);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        if (this.f8278b == pictureFrame.f8278b && this.f8279c.equals(pictureFrame.f8279c) && this.f8280d.equals(pictureFrame.f8280d) && this.f8281e == pictureFrame.f8281e && this.f8282f == pictureFrame.f8282f && this.f8283g == pictureFrame.f8283g && this.f8284h == pictureFrame.f8284h && Arrays.equals(this.f8285i, pictureFrame.f8285i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f8278b) * 31) + this.f8279c.hashCode()) * 31) + this.f8280d.hashCode()) * 31) + this.f8281e) * 31) + this.f8282f) * 31) + this.f8283g) * 31) + this.f8284h) * 31) + Arrays.hashCode(this.f8285i);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f8279c + ", description=" + this.f8280d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8278b);
        parcel.writeString(this.f8279c);
        parcel.writeString(this.f8280d);
        parcel.writeInt(this.f8281e);
        parcel.writeInt(this.f8282f);
        parcel.writeInt(this.f8283g);
        parcel.writeInt(this.f8284h);
        parcel.writeByteArray(this.f8285i);
    }

    PictureFrame(Parcel parcel) {
        this.f8278b = parcel.readInt();
        this.f8279c = (String) Util.i(parcel.readString());
        this.f8280d = (String) Util.i(parcel.readString());
        this.f8281e = parcel.readInt();
        this.f8282f = parcel.readInt();
        this.f8283g = parcel.readInt();
        this.f8284h = parcel.readInt();
        this.f8285i = (byte[]) Util.i(parcel.createByteArray());
    }
}
