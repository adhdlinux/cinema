package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        /* renamed from: a */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        /* renamed from: b */
        public InternalFrame[] newArray(int i2) {
            return new InternalFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f8330c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8331d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8332e;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f8330c = str;
        this.f8331d = str2;
        this.f8332e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        if (!Util.c(this.f8331d, internalFrame.f8331d) || !Util.c(this.f8330c, internalFrame.f8330c) || !Util.c(this.f8332e, internalFrame.f8332e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f8330c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f8331d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f8332e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return this.f8328b + ": domain=" + this.f8330c + ", description=" + this.f8331d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8328b);
        parcel.writeString(this.f8330c);
        parcel.writeString(this.f8332e);
    }

    InternalFrame(Parcel parcel) {
        super("----");
        this.f8330c = (String) Util.i(parcel.readString());
        this.f8331d = (String) Util.i(parcel.readString());
        this.f8332e = (String) Util.i(parcel.readString());
    }
}
