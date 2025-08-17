package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Assertions;

public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() {
        /* renamed from: a */
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) Assertions.e(parcel.readString()));
        }

        /* renamed from: b */
        public AppInfoTable[] newArray(int i2) {
            return new AppInfoTable[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f25366b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25367c;

    public AppInfoTable(int i2, String str) {
        this.f25366b = i2;
        this.f25367c = str;
    }

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

    public String toString() {
        return "Ait(controlCode=" + this.f25366b + ",url=" + this.f25367c + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25367c);
        parcel.writeInt(this.f25366b);
    }
}
