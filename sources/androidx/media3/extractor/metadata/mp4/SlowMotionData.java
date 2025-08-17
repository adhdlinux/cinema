package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new Parcelable.Creator<SlowMotionData>() {
        /* renamed from: a */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        /* renamed from: b */
        public SlowMotionData[] newArray(int i2) {
            return new SlowMotionData[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final List<Segment> f8350b;

    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator<Segment> CREATOR = new Parcelable.Creator<Segment>() {
            /* renamed from: a */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            /* renamed from: b */
            public Segment[] newArray(int i2) {
                return new Segment[i2];
            }
        };

        /* renamed from: e  reason: collision with root package name */
        public static final Comparator<Segment> f8351e = new a();

        /* renamed from: b  reason: collision with root package name */
        public final long f8352b;

        /* renamed from: c  reason: collision with root package name */
        public final long f8353c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8354d;

        public Segment(long j2, long j3, int i2) {
            boolean z2;
            if (j2 < j3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f8352b = j2;
            this.f8353c = j3;
            this.f8354d = i2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            if (this.f8352b == segment.f8352b && this.f8353c == segment.f8353c && this.f8354d == segment.f8354d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.f8352b), Long.valueOf(this.f8353c), Integer.valueOf(this.f8354d));
        }

        public String toString() {
            return Util.G("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f8352b), Long.valueOf(this.f8353c), Integer.valueOf(this.f8354d));
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f8352b);
            parcel.writeLong(this.f8353c);
            parcel.writeInt(this.f8354d);
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.f8350b = list;
        Assertions.a(!b(list));
    }

    private static boolean b(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j2 = list.get(0).f8353c;
        for (int i2 = 1; i2 < list.size(); i2++) {
            if (list.get(i2).f8352b < j2) {
                return true;
            }
            j2 = list.get(i2).f8353c;
        }
        return false;
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public /* synthetic */ void H(MediaMetadata.Builder builder) {
        d.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f8350b.equals(((SlowMotionData) obj).f8350b);
    }

    public int hashCode() {
        return this.f8350b.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f8350b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f8350b);
    }
}
