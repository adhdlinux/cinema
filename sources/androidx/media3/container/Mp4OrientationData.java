package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;

public final class Mp4OrientationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4OrientationData> CREATOR = new Parcelable.Creator<Mp4OrientationData>() {
        /* renamed from: a */
        public Mp4OrientationData createFromParcel(Parcel parcel) {
            return new Mp4OrientationData(parcel);
        }

        /* renamed from: b */
        public Mp4OrientationData[] newArray(int i2) {
            return new Mp4OrientationData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f4744b;

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
        if ((obj instanceof Mp4OrientationData) && this.f4744b == ((Mp4OrientationData) obj).f4744b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 527 + this.f4744b;
    }

    public String toString() {
        return "Orientation= " + this.f4744b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4744b);
    }

    private Mp4OrientationData(Parcel parcel) {
        this.f4744b = parcel.readInt();
    }
}
