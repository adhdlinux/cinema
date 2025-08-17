package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import com.google.common.primitives.Longs;

public final class Mp4TimestampData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4TimestampData> CREATOR = new Parcelable.Creator<Mp4TimestampData>() {
        /* renamed from: a */
        public Mp4TimestampData createFromParcel(Parcel parcel) {
            return new Mp4TimestampData(parcel);
        }

        /* renamed from: b */
        public Mp4TimestampData[] newArray(int i2) {
            return new Mp4TimestampData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final long f4745b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4746c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4747d;

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
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        if (this.f4745b == mp4TimestampData.f4745b && this.f4746c == mp4TimestampData.f4746c && this.f4747d == mp4TimestampData.f4747d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + Longs.b(this.f4745b)) * 31) + Longs.b(this.f4746c)) * 31) + Longs.b(this.f4747d);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.f4745b + ", modification time=" + this.f4746c + ", timescale=" + this.f4747d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f4745b);
        parcel.writeLong(this.f4746c);
        parcel.writeLong(this.f4747d);
    }

    public Mp4TimestampData(long j2, long j3, long j4) {
        this.f4745b = j2;
        this.f4746c = j3;
        this.f4747d = j4;
    }

    private Mp4TimestampData(Parcel parcel) {
        this.f4745b = parcel.readLong();
        this.f4746c = parcel.readLong();
        this.f4747d = parcel.readLong();
    }
}
