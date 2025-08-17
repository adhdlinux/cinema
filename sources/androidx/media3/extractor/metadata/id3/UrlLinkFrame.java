package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        /* renamed from: b */
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f8343c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8344d;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f8343c = str2;
        this.f8344d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (!this.f8328b.equals(urlLinkFrame.f8328b) || !Util.c(this.f8343c, urlLinkFrame.f8343c) || !Util.c(this.f8344d, urlLinkFrame.f8344d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = (527 + this.f8328b.hashCode()) * 31;
        String str = this.f8343c;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (hashCode + i2) * 31;
        String str2 = this.f8344d;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return this.f8328b + ": url=" + this.f8344d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8328b);
        parcel.writeString(this.f8343c);
        parcel.writeString(this.f8344d);
    }

    UrlLinkFrame(Parcel parcel) {
        super((String) Util.i(parcel.readString()));
        this.f8343c = parcel.readString();
        this.f8344d = (String) Util.i(parcel.readString());
    }
}
