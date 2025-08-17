package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
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
    public final float f8355b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8356c;

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
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        if (this.f8355b == smtaMetadataEntry.f8355b && this.f8356c == smtaMetadataEntry.f8356c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Floats.a(this.f8355b)) * 31) + this.f8356c;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f8355b + ", svcTemporalLayerCount=" + this.f8356c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f8355b);
        parcel.writeInt(this.f8356c);
    }

    public SmtaMetadataEntry(float f2, int i2) {
        this.f8355b = f2;
        this.f8356c = i2;
    }

    private SmtaMetadataEntry(Parcel parcel) {
        this.f8355b = parcel.readFloat();
        this.f8356c = parcel.readInt();
    }
}
