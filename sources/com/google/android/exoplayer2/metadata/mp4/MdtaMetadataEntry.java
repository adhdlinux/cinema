package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        /* renamed from: a */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        /* renamed from: b */
        public MdtaMetadataEntry[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f25444b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f25445c;

    /* renamed from: d  reason: collision with root package name */
    public final int f25446d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25447e;

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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        if (!this.f25444b.equals(mdtaMetadataEntry.f25444b) || !Arrays.equals(this.f25445c, mdtaMetadataEntry.f25445c) || this.f25446d != mdtaMetadataEntry.f25446d || this.f25447e != mdtaMetadataEntry.f25447e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f25444b.hashCode()) * 31) + Arrays.hashCode(this.f25445c)) * 31) + this.f25446d) * 31) + this.f25447e;
    }

    public String toString() {
        return "mdta: key=" + this.f25444b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25444b);
        parcel.writeByteArray(this.f25445c);
        parcel.writeInt(this.f25446d);
        parcel.writeInt(this.f25447e);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.f25444b = str;
        this.f25445c = bArr;
        this.f25446d = i2;
        this.f25447e = i3;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.f25444b = (String) Util.j(parcel.readString());
        this.f25445c = (byte[]) Util.j(parcel.createByteArray());
        this.f25446d = parcel.readInt();
        this.f25447e = parcel.readInt();
    }
}
