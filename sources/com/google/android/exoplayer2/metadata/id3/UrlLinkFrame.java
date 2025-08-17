package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

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
    public final String f25442c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25443d;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f25442c = str2;
        this.f25443d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (!this.f25428b.equals(urlLinkFrame.f25428b) || !Util.c(this.f25442c, urlLinkFrame.f25442c) || !Util.c(this.f25443d, urlLinkFrame.f25443d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = (527 + this.f25428b.hashCode()) * 31;
        String str = this.f25442c;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (hashCode + i2) * 31;
        String str2 = this.f25443d;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return this.f25428b + ": url=" + this.f25443d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25428b);
        parcel.writeString(this.f25442c);
        parcel.writeString(this.f25443d);
    }

    UrlLinkFrame(Parcel parcel) {
        super((String) Util.j(parcel.readString()));
        this.f25442c = parcel.readString();
        this.f25443d = (String) Util.j(parcel.readString());
    }
}
