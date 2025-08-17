package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

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
    public final String f8316c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8317d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8318e;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f8316c = str;
        this.f8317d = str2;
        this.f8318e = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (!Util.c(this.f8317d, commentFrame.f8317d) || !Util.c(this.f8316c, commentFrame.f8316c) || !Util.c(this.f8318e, commentFrame.f8318e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f8316c;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (527 + i2) * 31;
        String str2 = this.f8317d;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f8318e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return this.f8328b + ": language=" + this.f8316c + ", description=" + this.f8317d + ", text=" + this.f8318e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8328b);
        parcel.writeString(this.f8316c);
        parcel.writeString(this.f8318e);
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f8316c = (String) Util.i(parcel.readString());
        this.f8317d = (String) Util.i(parcel.readString());
        this.f8318e = (String) Util.i(parcel.readString());
    }
}
