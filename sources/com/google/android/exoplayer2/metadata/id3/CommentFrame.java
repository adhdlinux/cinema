package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        /* renamed from: b */
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25416c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25417d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25418e;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f25416c = str;
        this.f25417d = str2;
        this.f25418e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (!Util.c(this.f25417d, commentFrame.f25417d) || !Util.c(this.f25416c, commentFrame.f25416c) || !Util.c(this.f25418e, commentFrame.f25418e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f25416c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f25417d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f25418e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return this.f25428b + ": language=" + this.f25416c + ", description=" + this.f25417d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25428b);
        parcel.writeString(this.f25416c);
        parcel.writeString(this.f25418e);
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f25416c = (String) Util.j(parcel.readString());
        this.f25417d = (String) Util.j(parcel.readString());
        this.f25418e = (String) Util.j(parcel.readString());
    }
}
