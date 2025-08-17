package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
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
    public final List<Segment> f25453b;

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
        public static final Comparator<Segment> f25454e = new a();

        /* renamed from: b  reason: collision with root package name */
        public final long f25455b;

        /* renamed from: c  reason: collision with root package name */
        public final long f25456c;

        /* renamed from: d  reason: collision with root package name */
        public final int f25457d;

        public Segment(long j2, long j3, int i2) {
            boolean z2;
            if (j2 < j3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f25455b = j2;
            this.f25456c = j3;
            this.f25457d = i2;
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
            if (this.f25455b == segment.f25455b && this.f25456c == segment.f25456c && this.f25457d == segment.f25457d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.f25455b), Long.valueOf(this.f25456c), Integer.valueOf(this.f25457d));
        }

        public String toString() {
            return Util.C("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f25455b), Long.valueOf(this.f25456c), Integer.valueOf(this.f25457d));
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f25455b);
            parcel.writeLong(this.f25456c);
            parcel.writeInt(this.f25457d);
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.f25453b = list;
        Assertions.a(!b(list));
    }

    private static boolean b(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j2 = list.get(0).f25456c;
        for (int i2 = 1; i2 < list.size(); i2++) {
            if (list.get(i2).f25455b < j2) {
                return true;
            }
            j2 = list.get(i2).f25456c;
        }
        return false;
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public /* synthetic */ void a(MediaMetadata.Builder builder) {
        a.c(this, builder);
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
        return this.f25453b.equals(((SlowMotionData) obj).f25453b);
    }

    public int hashCode() {
        return this.f25453b.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f25453b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f25453b);
    }
}
