package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

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
    public final String f25429c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25430d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25431e;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f25429c = str;
        this.f25430d = str2;
        this.f25431e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        if (!Util.c(this.f25430d, internalFrame.f25430d) || !Util.c(this.f25429c, internalFrame.f25429c) || !Util.c(this.f25431e, internalFrame.f25431e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f25429c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f25430d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f25431e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return this.f25428b + ": domain=" + this.f25429c + ", description=" + this.f25430d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25428b);
        parcel.writeString(this.f25429c);
        parcel.writeString(this.f25431e);
    }

    InternalFrame(Parcel parcel) {
        super("----");
        this.f25429c = (String) Util.j(parcel.readString());
        this.f25430d = (String) Util.j(parcel.readString());
        this.f25431e = (String) Util.j(parcel.readString());
    }
}
