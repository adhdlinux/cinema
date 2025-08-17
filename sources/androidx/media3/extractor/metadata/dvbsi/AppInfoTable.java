package androidx.media3.extractor.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Assertions;

public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() {
        /* renamed from: a */
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) Assertions.f(parcel.readString()));
        }

        /* renamed from: b */
        public AppInfoTable[] newArray(int i2) {
            return new AppInfoTable[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f8266b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8267c;

    public AppInfoTable(int i2, String str) {
        this.f8266b = i2;
        this.f8267c = str;
    }

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

    public String toString() {
        return "Ait(controlCode=" + this.f8266b + ",url=" + this.f8267c + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8267c);
        parcel.writeInt(this.f8266b);
    }
}
