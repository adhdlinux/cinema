package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

final class MotionPhotoDescription {

    /* renamed from: a  reason: collision with root package name */
    public final long f24401a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ContainerItem> f24402b;

    public static final class ContainerItem {

        /* renamed from: a  reason: collision with root package name */
        public final String f24403a;

        /* renamed from: b  reason: collision with root package name */
        public final String f24404b;

        /* renamed from: c  reason: collision with root package name */
        public final long f24405c;

        /* renamed from: d  reason: collision with root package name */
        public final long f24406d;

        public ContainerItem(String str, String str2, long j2, long j3) {
            this.f24403a = str;
            this.f24404b = str2;
            this.f24405c = j2;
            this.f24406d = j3;
        }
    }

    public MotionPhotoDescription(long j2, List<ContainerItem> list) {
        this.f24401a = j2;
        this.f24402b = list;
    }

    public MotionPhotoMetadata a(long j2) {
        long j3;
        if (this.f24402b.size() < 2) {
            return null;
        }
        long j4 = j2;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        long j8 = -1;
        boolean z2 = false;
        for (int size = this.f24402b.size() - 1; size >= 0; size--) {
            ContainerItem containerItem = this.f24402b.get(size);
            boolean equals = "video/mp4".equals(containerItem.f24403a) | z2;
            if (size == 0) {
                j4 -= containerItem.f24406d;
                j3 = 0;
            } else {
                j3 = j4 - containerItem.f24405c;
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
        return new MotionPhotoMetadata(j5, j6, this.f24401a, j7, j8);
    }
}
