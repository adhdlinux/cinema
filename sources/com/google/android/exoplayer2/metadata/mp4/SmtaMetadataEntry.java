package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.common.primitives.Floats;

public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new Parcelable.Creator<SmtaMetadataEntry>() {
        /* renamed from: a */
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel);
        }

        /* renamed from: b */
        public SmtaMetadataEntry[] newArray(int i2) {
            return new SmtaMetadataEntry[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final float f25458b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25459c;

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
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        if (this.f25458b == smtaMetadataEntry.f25458b && this.f25459c == smtaMetadataEntry.f25459c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Floats.a(this.f25458b)) * 31) + this.f25459c;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f25458b + ", svcTemporalLayerCount=" + this.f25459c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f25458b);
        parcel.writeInt(this.f25459c);
    }

    public SmtaMetadataEntry(float f2, int i2) {
        this.f25458b = f2;
        this.f25459c = i2;
    }

    private SmtaMetadataEntry(Parcel parcel) {
        this.f25458b = parcel.readFloat();
        this.f25459c = parcel.readInt();
    }
}
