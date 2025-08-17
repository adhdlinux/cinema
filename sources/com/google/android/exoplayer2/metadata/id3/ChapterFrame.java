package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* renamed from: b */
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25405c;

    /* renamed from: d  reason: collision with root package name */
    public final int f25406d;

    /* renamed from: e  reason: collision with root package name */
    public final int f25407e;

    /* renamed from: f  reason: collision with root package name */
    public final long f25408f;

    /* renamed from: g  reason: collision with root package name */
    public final long f25409g;

    /* renamed from: h  reason: collision with root package name */
    private final Id3Frame[] f25410h;

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f25405c = str;
        this.f25406d = i2;
        this.f25407e = i3;
        this.f25408f = j2;
        this.f25409g = j3;
        this.f25410h = id3FrameArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.f25406d == chapterFrame.f25406d && this.f25407e == chapterFrame.f25407e && this.f25408f == chapterFrame.f25408f && this.f25409g == chapterFrame.f25409g && Util.c(this.f25405c, chapterFrame.f25405c) && Arrays.equals(this.f25410h, chapterFrame.f25410h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3 = (((((((527 + this.f25406d) * 31) + this.f25407e) * 31) + ((int) this.f25408f)) * 31) + ((int) this.f25409g)) * 31;
        String str = this.f25405c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25405c);
        parcel.writeInt(this.f25406d);
        parcel.writeInt(this.f25407e);
        parcel.writeLong(this.f25408f);
        parcel.writeLong(this.f25409g);
        parcel.writeInt(this.f25410h.length);
        for (Id3Frame writeParcelable : this.f25410h) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f25405c = (String) Util.j(parcel.readString());
        this.f25406d = parcel.readInt();
        this.f25407e = parcel.readInt();
        this.f25408f = parcel.readLong();
        this.f25409g = parcel.readLong();
        int readInt = parcel.readInt();
        this.f25410h = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f25410h[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
