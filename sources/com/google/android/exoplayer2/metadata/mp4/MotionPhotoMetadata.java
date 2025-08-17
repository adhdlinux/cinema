package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
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
    public final long f25448b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25449c;

    /* renamed from: d  reason: collision with root package name */
    public final long f25450d;

    /* renamed from: e  reason: collision with root package name */
    public final long f25451e;

    /* renamed from: f  reason: collision with root package name */
    public final long f25452f;

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public /* synthetic */ void a(MediaMetadata.Builder builder) {
        a.c(this, builder);
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
        if (this.f25448b == motionPhotoMetadata.f25448b && this.f25449c == motionPhotoMetadata.f25449c && this.f25450d == motionPhotoMetadata.f25450d && this.f25451e == motionPhotoMetadata.f25451e && this.f25452f == motionPhotoMetadata.f25452f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + Longs.b(this.f25448b)) * 31) + Longs.b(this.f25449c)) * 31) + Longs.b(this.f25450d)) * 31) + Longs.b(this.f25451e)) * 31) + Longs.b(this.f25452f);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f25448b + ", photoSize=" + this.f25449c + ", photoPresentationTimestampUs=" + this.f25450d + ", videoStartPosition=" + this.f25451e + ", videoSize=" + this.f25452f;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f25448b);
        parcel.writeLong(this.f25449c);
        parcel.writeLong(this.f25450d);
        parcel.writeLong(this.f25451e);
        parcel.writeLong(this.f25452f);
    }

    public MotionPhotoMetadata(long j2, long j3, long j4, long j5, long j6) {
        this.f25448b = j2;
        this.f25449c = j3;
        this.f25450d = j4;
        this.f25451e = j5;
        this.f25452f = j6;
    }

    private MotionPhotoMetadata(Parcel parcel) {
        this.f25448b = parcel.readLong();
        this.f25449c = parcel.readLong();
        this.f25450d = parcel.readLong();
        this.f25451e = parcel.readLong();
        this.f25452f = parcel.readLong();
    }
}
