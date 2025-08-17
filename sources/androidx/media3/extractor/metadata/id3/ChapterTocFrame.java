package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
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
    public final String f8311c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8312d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8313e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f8314f;

    /* renamed from: g  reason: collision with root package name */
    private final Id3Frame[] f8315g;

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f8311c = str;
        this.f8312d = z2;
        this.f8313e = z3;
        this.f8314f = strArr;
        this.f8315g = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.f8312d != chapterTocFrame.f8312d || this.f8313e != chapterTocFrame.f8313e || !Util.c(this.f8311c, chapterTocFrame.f8311c) || !Arrays.equals(this.f8314f, chapterTocFrame.f8314f) || !Arrays.equals(this.f8315g, chapterTocFrame.f8315g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3 = (((true + (this.f8312d ? 1 : 0)) * 31) + (this.f8313e ? 1 : 0)) * 31;
        String str = this.f8311c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8311c);
        parcel.writeByte(this.f8312d ? (byte) 1 : 0);
        parcel.writeByte(this.f8313e ? (byte) 1 : 0);
        parcel.writeStringArray(this.f8314f);
        parcel.writeInt(this.f8315g.length);
        for (Id3Frame writeParcelable : this.f8315g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f8311c = (String) Util.i(parcel.readString());
        boolean z2 = true;
        this.f8312d = parcel.readByte() != 0;
        this.f8313e = parcel.readByte() == 0 ? false : z2;
        this.f8314f = (String[]) Util.i(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f8315g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f8315g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
