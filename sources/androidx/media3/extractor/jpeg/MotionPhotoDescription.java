package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

final class MotionPhotoDescription {

    /* renamed from: a  reason: collision with root package name */
    public final long f8251a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ContainerItem> f8252b;

    public static final class ContainerItem {

        /* renamed from: a  reason: collision with root package name */
        public final String f8253a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8254b;

        /* renamed from: c  reason: collision with root package name */
        public final long f8255c;

        /* renamed from: d  reason: collision with root package name */
        public final long f8256d;

        public ContainerItem(String str, String str2, long j2, long j3) {
            this.f8253a = str;
            this.f8254b = str2;
            this.f8255c = j2;
            this.f8256d = j3;
        }
    }

    public MotionPhotoDescription(long j2, List<ContainerItem> list) {
        this.f8251a = j2;
        this.f8252b = list;
    }

    public MotionPhotoMetadata a(long j2) {
        long j3;
        if (this.f8252b.size() < 2) {
            return null;
        }
        long j4 = j2;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        long j8 = -1;
        boolean z2 = false;
        for (int size = this.f8252b.size() - 1; size >= 0; size--) {
            ContainerItem containerItem = this.f8252b.get(size);
            boolean equals = "video/mp4".equals(containerItem.f8253a) | z2;
            if (size == 0) {
                j4 -= containerItem.f8256d;
                j3 = 0;
            } else {
                j3 = j4 - containerItem.f8255c;
            }
            long j9 = j4;
            j4 = j3;
            long j10 = j9;
            if (!equals || j4 == j10) {
                z2 = equals;
            } else {
                j8 = j10 - j4;
                j7 = j4;
                z2 = false;
            }
            if (size == 0) {
                j5 = j4;
                j6 = j10;
            }
        }
        if (j7 == -1 || j8 == -1 || j5 == -1 || j6 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j5, j6, this.f8251a, j7, j8);
    }
}
