package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Util;
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
    private final Entry[] f4283b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4284c;

    public interface Entry extends Parcelable {
        Format D();

        byte[] E();

        void H(MediaMetadata.Builder builder);
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public Metadata b(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata(this.f4284c, (Entry[]) Util.T0(this.f4283b, entryArr));
    }

    public Metadata c(Metadata metadata) {
        return metadata == null ? this : b(metadata.f4283b);
    }

    public Metadata d(long j2) {
        if (this.f4284c == j2) {
            return this;
        }
        return new Metadata(j2, this.f4283b);
    }

    public int describeContents() {
        return 0;
    }

    public Entry e(int i2) {
        return this.f4283b[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        if (!Arrays.equals(this.f4283b, metadata.f4283b) || this.f4284c != metadata.f4284c) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f4283b.length;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f4283b) * 31) + Longs.b(this.f4284c);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f4283b));
        if (this.f4284c == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f4284c;
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4283b.length);
        for (Entry writeParcelable : this.f4283b) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.f4284c);
    }

    public Metadata(long j2, Entry... entryArr) {
        this.f4284c = j2;
        this.f4283b = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(long j2, List<? extends Entry> list) {
        this(j2, (Entry[]) list.toArray(new Entry[0]));
    }

    Metadata(Parcel parcel) {
        this.f4283b = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f4283b;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                this.f4284c = parcel.readLong();
                return;
            }
        }
    }
}
