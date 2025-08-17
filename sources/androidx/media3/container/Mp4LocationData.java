package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Assertions;
import com.google.common.primitives.Floats;

public final class Mp4LocationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4LocationData> CREATOR = new Parcelable.Creator<Mp4LocationData>() {
        /* renamed from: a */
        public Mp4LocationData createFromParcel(Parcel parcel) {
            return new Mp4LocationData(parcel);
        }

        /* renamed from: b */
        public Mp4LocationData[] newArray(int i2) {
            return new Mp4LocationData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final float f4742b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4743c;

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
        if (obj == null || Mp4LocationData.class != obj.getClass()) {
            return false;
        }
        Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
        if (this.f4742b == mp4LocationData.f4742b && this.f4743c == mp4LocationData.f4743c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Floats.a(this.f4742b)) * 31) + Floats.a(this.f4743c);
    }

    public String toString() {
        return "xyz: latitude=" + this.f4742b + ", longitude=" + this.f4743c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f4742b);
        parcel.writeFloat(this.f4743c);
    }

    public Mp4LocationData(float f2, float f3) {
        Assertions.b(f2 >= -90.0f && f2 <= 90.0f && f3 >= -180.0f && f3 <= 180.0f, "Invalid latitude or longitude");
        this.f4742b = f2;
        this.f4743c = f3;
    }

    private Mp4LocationData(Parcel parcel) {
        this.f4742b = parcel.readFloat();
        this.f4743c = parcel.readFloat();
    }
}
