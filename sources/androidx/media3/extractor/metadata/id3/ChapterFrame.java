package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
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
    public final String f8305c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8306d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8307e;

    /* renamed from: f  reason: collision with root package name */
    public final long f8308f;

    /* renamed from: g  reason: collision with root package name */
    public final long f8309g;

    /* renamed from: h  reason: collision with root package name */
    private final Id3Frame[] f8310h;

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f8305c = str;
        this.f8306d = i2;
        this.f8307e = i3;
        this.f8308f = j2;
        this.f8309g = j3;
        this.f8310h = id3FrameArr;
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
        if (this.f8306d == chapterFrame.f8306d && this.f8307e == chapterFrame.f8307e && this.f8308f == chapterFrame.f8308f && this.f8309g == chapterFrame.f8309g && Util.c(this.f8305c, chapterFrame.f8305c) && Arrays.equals(this.f8310h, chapterFrame.f8310h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3 = (((((((527 + this.f8306d) * 31) + this.f8307e) * 31) + ((int) this.f8308f)) * 31) + ((int) this.f8309g)) * 31;
        String str = this.f8305c;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return i3 + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8305c);
        parcel.writeInt(this.f8306d);
        parcel.writeInt(this.f8307e);
        parcel.writeLong(this.f8308f);
        parcel.writeLong(this.f8309g);
        parcel.writeInt(this.f8310h.length);
        for (Id3Frame writeParcelable : this.f8310h) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f8305c = (String) Util.i(parcel.readString());
        this.f8306d = parcel.readInt();
        this.f8307e = parcel.readInt();
        this.f8308f = parcel.readLong();
        this.f8309g = parcel.readLong();
        int readInt = parcel.readInt();
        this.f8310h = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f8310h[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
