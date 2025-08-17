package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* renamed from: b */
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final String f25411c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f25412d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f25413e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f25414f;

    /* renamed from: g  reason: collision with root package name */
    private final Id3Frame[] f25415g;

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f25411c = str;
        this.f25412d = z2;
        this.f25413e = z3;
        this.f25414f = strArr;
        this.f25415g = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.f25412d != chapterTocFrame.f25412d || this.f25413e != chapterTocFrame.f25413e || !Util.c(this.f25411c, chapterTocFrame.f25411c) || !Arrays.equals(this.f25414f, chapterTocFrame.f25414f) || !Arrays.equals(this.f25415g, chapterTocFrame.f25415g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3 = (((true + (this.f25412d ? 1 : 0)) * 31) + (this.f25413e ? 1 : 0)) * 31;
        String str = this.f25411c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25411c);
        parcel.writeByte(this.f25412d ? (byte) 1 : 0);
        parcel.writeByte(this.f25413e ? (byte) 1 : 0);
        parcel.writeStringArray(this.f25414f);
        parcel.writeInt(this.f25415g.length);
        for (Id3Frame writeParcelable : this.f25415g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f25411c = (String) Util.j(parcel.readString());
        boolean z2 = true;
        this.f25412d = parcel.readByte() != 0;
        this.f25413e = parcel.readByte() == 0 ? false : z2;
        this.f25414f = (String[]) Util.j(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f25415g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f25415g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
