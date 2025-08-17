package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        /* renamed from: b */
        public Metadata[] newArray(int i2) {
            return new Metadata[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Entry[] f25351b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25352c;

    public interface Entry extends Parcelable {
        Format D();

        byte[] E();

        void a(MediaMetadata.Builder builder);
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public Metadata b(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata(this.f25352c, (Entry[]) Util.J0(this.f25351b, entryArr));
    }

    public Metadata c(Metadata metadata) {
        return metadata == null ? this : b(metadata.f25351b);
    }

    public Metadata d(long j2) {
        if (this.f25352c == j2) {
            return this;
        }
        return new Metadata(j2, this.f25351b);
    }

    public int describeContents() {
        return 0;
    }

    public Entry e(int i2) {
        return this.f25351b[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        if (!Arrays.equals(this.f25351b, metadata.f25351b) || this.f25352c != metadata.f25352c) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f25351b.length;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f25351b) * 31) + Longs.b(this.f25352c);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f25351b));
        if (this.f25352c == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f25352c;
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f25351b.length);
        for (Entry writeParcelable : this.f25351b) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.f25352c);
    }

    public Metadata(long j2, Entry... entryArr) {
        this.f25352c = j2;
        this.f25351b = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(long j2, List<? extends Entry> list) {
        this(j2, (Entry[]) list.toArray(new Entry[0]));
    }

    Metadata(Parcel parcel) {
        this.f25351b = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f25351b;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                this.f25352c = parcel.readLong();
                return;
            }
        }
    }
}
