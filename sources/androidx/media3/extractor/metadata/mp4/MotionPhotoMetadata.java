package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import com.google.common.primitives.Longs;

public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new Parcelable.Creator<MotionPhotoMetadata>() {
        /* renamed from: a */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel);
        }

        /* renamed from: b */
        public MotionPhotoMetadata[] newArray(int i2) {
            return new MotionPhotoMetadata[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final long f8345b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8346c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8347d;

    /* renamed from: e  reason: collision with root package name */
    public final long f8348e;

    /* renamed from: f  reason: collision with root package name */
    public final long f8349f;

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
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        if (this.f8345b == motionPhotoMetadata.f8345b && this.f8346c == motionPhotoMetadata.f8346c && this.f8347d == motionPhotoMetadata.f8347d && this.f8348e == motionPhotoMetadata.f8348e && this.f8349f == motionPhotoMetadata.f8349f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + Longs.b(this.f8345b)) * 31) + Longs.b(this.f8346c)) * 31) + Longs.b(this.f8347d)) * 31) + Longs.b(this.f8348e)) * 31) + Longs.b(this.f8349f);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f8345b + ", photoSize=" + this.f8346c + ", photoPresentationTimestampUs=" + this.f8347d + ", videoStartPosition=" + this.f8348e + ", videoSize=" + this.f8349f;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8345b);
        parcel.writeLong(this.f8346c);
        parcel.writeLong(this.f8347d);
        parcel.writeLong(this.f8348e);
        parcel.writeLong(this.f8349f);
    }

    public MotionPhotoMetadata(long j2, long j3, long j4, long j5, long j6) {
        this.f8345b = j2;
        this.f8346c = j3;
        this.f8347d = j4;
        this.f8348e = j5;
        this.f8349f = j6;
    }

    private MotionPhotoMetadata(Parcel parcel) {
        this.f8345b = parcel.readLong();
        this.f8346c = parcel.readLong();
        this.f8347d = parcel.readLong();
        this.f8348e = parcel.readLong();
        this.f8349f = parcel.readLong();
    }
}
